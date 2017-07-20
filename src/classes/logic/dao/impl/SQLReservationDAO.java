package classes.logic.dao.impl;


import classes.logic.bean.Reservation;
import classes.logic.dao.connectionPool.ConnectionPool;
import classes.logic.dao.connectionPool.exception.ConnectionPoolException;
import classes.logic.dao.DAOReservation;
import classes.logic.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLReservationDAO implements DAOReservation {

    private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

    public SQLReservationDAO()
    {
        try {
            connectionPool.initPool();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String addReservation(Reservation reservation) throws DAOException {
        return null;
    }

    @Override
    public String deleteReservation(Reservation reservation) throws DAOException {
        return null;
    }

    @Override
    public List takeAllReservationByUser(String login) throws DAOException {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List reservations = new ArrayList<Reservation>();

        try{

            connection = connectionPool.takeConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT title, cinemaTitle, date, price, numberOfTheChair, countTickets FROM reservation INNER JOIN user ON user.idUser = reservation.idUser INNER JOIN movie ON movie.idMovie = reservation.idMovie WHERE user.login LIKE \'" + login + "\'");
            while (resultSet.next())
            {
                Reservation reservation = new Reservation();
                reservation.setMovieTitle(resultSet.getString(1));
                reservation.setCinemaTitle(resultSet.getString(2));
                reservation.setDate(resultSet.getDate(3));
                reservation.setPrice(resultSet.getInt(4));
                reservation.setNumberOfTheChair(resultSet.getString(5));
                reservation.setCountTickets(resultSet.getInt(6));
                reservations.add(reservation);
            }

        }catch (ConnectionPoolException|SQLException e) {
            e.printStackTrace();
        }
        finally {
            connectionPool.closeConnection(connection,statement,resultSet);
        }
        return reservations;
    }

    @Override
    public List takeAllReservation() throws DAOException {
        return null;
    }

}
