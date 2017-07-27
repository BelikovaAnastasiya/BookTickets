package epam.bookticket.logic.dao.impl;


import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.dao.connectionPool.ConnectionPool;
import epam.bookticket.logic.dao.connectionPool.exception.ConnectionPoolException;
import epam.bookticket.logic.dao.DAOUser;
import epam.bookticket.logic.dao.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLUserDAO implements DAOUser {
    private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

    public SQLUserDAO()
    {
        try {
            connectionPool.initPool();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String signIn(String login, String password) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        String response = null;

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("SELECT user.login, user.password, user.isAdmin FROM user WHERE login LIKE ? AND password LIKE ? ");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                response = "success";
               if(resultSet.getInt(3)== 1)
               {
                   response = response + " admin";
               }
                else
               {
                   response = response + " user";
               }
            }
            else
            {
                response = "empty ";
            }
        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement,resultSet);
        }
        return response;
    }

    @Override
    public boolean registration(User user) throws DAOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        boolean response = false;

        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user(isAdmin, login, password, mail, name, surname, numberCreditCard, phone, idBenefit)  VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getMail());
            preparedStatement.setString(5, user.getName());
            preparedStatement.setString(6, user.getSurname());
            preparedStatement.setString(7, user.getNumberCreditCard());
            preparedStatement.setString(8, user.getPhone());
            preparedStatement.setInt(9, 2);

            int result = preparedStatement.executeUpdate();
            if (result == 1)
            {
                response = true;
            }
        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement);
        }
        return response;
    }

    @Override
    public String takeProfileInformation(String login) throws DAOException {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        String response = null;

        try{
            char param = ',';
            connection = connectionPool.takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("(SELECT login, password, mail, name, surname, numberCreditCard, phone, sizeBenefit FROM user INNER JOIN benefit ON user.idBenefit = benefit.idBenefit WHERE user.login LIKE \'"+login+"\')"+"UNION (SELECT login, password, mail, name, surname,numberCreditCard, phone, idBenefit FROM user WHERE user.idBenefit is null and user.login LIKE \'" + login +"\')");
            while(resultSet.next())
            {
                response = resultSet.getString(1)+ param + resultSet.getString(2) + param + resultSet.getString(3) + param
                        + resultSet.getString(4) + param + resultSet.getString(5) + param + resultSet.getString(6) + param
                        + resultSet.getString(7) + param + String.valueOf(resultSet.getInt(8));
            }

        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,statement,resultSet);
        }
        return "success " + response;

    }

    @Override
    public boolean deleteUser(String login) throws DAOException {
        boolean response = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM user WHERE login LIKE ?");
            preparedStatement.setString(1, login);
            int result = preparedStatement.executeUpdate();
            if (result == 1)
            {
                response = true;
            }

        } catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        } catch (SQLException e) {
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement);
        }
        return response;
    }

    @Override
    public boolean editInformationAboutUser(String login, String parametr, String newInformation) throws DAOException {
        boolean response = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("UPDATE user SET " + parametr +" = ? WHERE login = ?");
            preparedStatement.setString(1, newInformation);
            preparedStatement.setString(2, login);
            int result = preparedStatement.executeUpdate();

            if(result == 1)
            {
                response = true;
            }

        } catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        } catch (SQLException e) {
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement);
        }
        return response;
    }


    @Override
    public List takeAllUsers() throws DAOException {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List<User> users = new ArrayList<>();

        try{
            connection = connectionPool.takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("(SELECT login, password, mail, name, surname, phone, sizeBenefit FROM user INNER JOIN benefit ON user.idBenefit = benefit.idBenefit WHERE user.isAdmin = 0) UNION (SELECT login, password, mail, name, surname, phone, idBenefit FROM user WHERE user.idBenefit is null and user.isAdmin = 0)");

            while (resultSet.next())
            {
                User user = new User();
                user.setLogin(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setMail(resultSet.getString(3));
                user.setName(resultSet.getString(4));
                user.setSurname(resultSet.getString(5));
                user.setPhone(resultSet.getString(6));
                user.setSizeBenefit(resultSet.getInt(7));
                users.add(user);
            }

        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,statement,resultSet);
        }
        return users;
    }
}
