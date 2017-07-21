package epam.bookticket.logic.dao.impl;

import epam.bookticket.logic.bean.Benefit;
import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.dao.connectionPool.ConnectionPool;
import epam.bookticket.logic.dao.connectionPool.exception.ConnectionPoolException;
import epam.bookticket.logic.dao.DAOBenefit;
import epam.bookticket.logic.dao.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLBenefitDAO implements DAOBenefit {

    private static ConnectionPool connectionPool =  ConnectionPool.getConnectionPool();

    public SQLBenefitDAO()
    {
        try {
            connectionPool.initPool();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean addBenefit(Benefit benefit) throws DAOException {
        Boolean response = false;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO benefit(typeBenefit, sizeBenefit) VALUES (?,?)");
            preparedStatement.setString(1,benefit.getTypeBenefit());
            preparedStatement.setInt(2, benefit.getSizeBenefit());

            int result = preparedStatement.executeUpdate();
            if(result == 1)
            {
                response = true;
            }

        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database to database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement);
        }
        return response;
    }

    @Override
    public Boolean addBenefitToUser(Benefit benefit, User user) throws DAOException {
        return null;
    }

    @Override
    public List takeAllBenefits() throws DAOException {
        Statement statement = null;
        Connection connection = null;
        ResultSet resultSet = null;
        List benefits = new ArrayList<Benefit>();

        try{
            connection = connectionPool.takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT typeBenefit, sizeBenefit FROM benefit");
            while (resultSet.next())
            {
                Benefit benefit = new Benefit();
                benefit.setTypeBenefit(resultSet.getString(1));
                benefit.setSizeBenefit(resultSet.getInt(2));
                benefits.add(benefit);
            }

        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open  connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,statement,resultSet);
        }
        return benefits;
    }

    @Override
    public Boolean deleteBenefit(String name) throws DAOException {

        Boolean response = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM benefit WHERE typeBenefit LIKE ?");
            preparedStatement.setString(1, name);
            int result = preparedStatement.executeUpdate();
            if(result == 1)
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
}
