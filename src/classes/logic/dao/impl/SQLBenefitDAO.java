package classes.logic.dao.impl;

import classes.logic.bean.Benefit;
import classes.logic.bean.User;
import classes.logic.connectionPool.ConnectionPool;
import classes.logic.connectionPool.exception.ConnectionPoolException;
import classes.logic.dao.DAOBenefit;
import classes.logic.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public String addBenefit(Benefit benefit) throws DAOException {
        return null;
    }

    @Override
    public String addBenefitToUser(Benefit benefit, User user) throws DAOException {
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
        }
        finally {
            connectionPool.closeConnection(connection,statement,resultSet);
        }
        return benefits;
    }
}
