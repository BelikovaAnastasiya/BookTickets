package epam.bookticket.logic.dao.impl;


import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.dao.DAOReservation;
import epam.bookticket.logic.dao.connectionPool.ConnectionPool;
import epam.bookticket.logic.dao.connectionPool.exception.ConnectionPoolException;
import epam.bookticket.logic.dao.exception.DAOException;

import java.sql.*;
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
    public boolean addReservation(Reservation reservation) throws DAOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        boolean answer = false;
        int userId = 0;
        int movieId = 0;

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("SELECT idUser FROM user WHERE login LIKE ?");
            preparedStatement.setString(1, reservation.getLoginUser());
            ResultSet resultSetUser = preparedStatement.executeQuery();
            while (resultSetUser.next())
            {
                userId = resultSetUser.getInt(1);
            }
            preparedStatement = connection.prepareStatement("SELECT idMovie FROM movie WHERE title LIKE ?");
            preparedStatement.setString(1, reservation.getMovieTitle());
            ResultSet resultSetMovie = preparedStatement.executeQuery();
            while (resultSetMovie.next())
            {
                movieId  = resultSetMovie.getInt(1);
            }
            preparedStatement = connection.prepareStatement("INSERT INTO reservation(date, price, numberOfTheChair, countTickets, cinemaTitle, idUser, idMovie, isPaid) VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, reservation.getDate());
            preparedStatement.setDouble(2, reservation.getPrice());
            preparedStatement.setString(3, reservation.getNumberOfTheChair());
            preparedStatement.setInt(4, reservation.getCountTickets());
            preparedStatement.setString(5, reservation.getCinemaTitle());
            preparedStatement.setInt(6, userId);
            preparedStatement.setInt(7, movieId);
            preparedStatement.setBoolean(8, reservation.isPaid());
            int result = preparedStatement.executeUpdate();
            if(result == 1)
            {
                answer = true;
            }

        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement);
        }
        return answer;
    }

    @Override
    public boolean deleteReservation(Reservation reservation) throws DAOException {
        return false;
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
                reservation.setDate(String.valueOf(resultSet.getDate(3)));
                reservation.setPrice(resultSet.getInt(4));
                reservation.setNumberOfTheChair(resultSet.getString(5));
                reservation.setCountTickets(resultSet.getInt(6));
                reservations.add(reservation);
            }

        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,statement,resultSet);
        }
        return reservations;
    }
}
