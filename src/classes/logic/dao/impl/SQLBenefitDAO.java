package classes.logic.dao.impl;

import classes.logic.bean.Benefit;
import classes.logic.bean.User;
import classes.logic.dao.connectionPool.ConnectionPool;
import classes.logic.dao.connectionPool.exception.ConnectionPoolException;
import classes.logic.dao.DAOBenefit;
import classes.logic.dao.exception.DAOException;

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

        }catch (ConnectionPoolException|SQLException e) {
            e.printStackTrace();
            return response;
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

        }catch (ConnectionPoolException|SQLException e) {
            e.printStackTrace();
            return null;
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

        } catch (ConnectionPoolException e) {
            e.printStackTrace();
            return response;
        } catch (SQLException e) {
            e.printStackTrace();
            return response;
        }finally {
            connectionPool.closeConnection(connection,preparedStatement);
        }
        return response;
    }
}
