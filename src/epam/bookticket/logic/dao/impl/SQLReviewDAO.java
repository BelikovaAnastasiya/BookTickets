package epam.bookticket.logic.dao.impl;


import epam.bookticket.logic.bean.Movie;
import epam.bookticket.logic.bean.Review;
import epam.bookticket.logic.dao.connectionPool.ConnectionPool;
import epam.bookticket.logic.dao.connectionPool.exception.ConnectionPoolException;
import epam.bookticket.logic.dao.DAOReview;
import epam.bookticket.logic.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLReviewDAO implements DAOReview {
    private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

    public SQLReviewDAO()
    {
        try {
            connectionPool.initPool();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addReview(Review review) throws DAOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        boolean answer = false;
        boolean check = false;
        int idUser = 0, idMovie = 0;

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("SELECT idUser FROM user WHERE login LIKE ?");
            preparedStatement.setString(1, review.getLoginUser());
            ResultSet resultSetUser = preparedStatement.executeQuery();
            while (resultSetUser.next())
            {
                idUser = resultSetUser.getInt(1);
            }

            preparedStatement = connection.prepareStatement("SELECT idMovie FROM movie WHERE title LIKE ?");
            preparedStatement.setString(1, review.getMovieTitle());
            ResultSet resultSetMovie = preparedStatement.executeQuery();
            while (resultSetMovie.next())
            {
                check = true;
                idMovie = resultSetMovie.getInt(1);
            }
            if (check)
            {
                preparedStatement = connection.prepareStatement("INSERT INTO review(rating, textReview, idUser, idMovie) VALUES (?,?,?,?)");
                preparedStatement.setInt(1,review.getRating());
                preparedStatement.setString(2, review.getTextReview());
                preparedStatement.setInt(3, idUser);
                preparedStatement.setInt(4, idMovie);

                int result = preparedStatement.executeUpdate();
                if(result == 1)
                {
                    answer = true;
                }
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
    public boolean deleteReview(Review review) throws DAOException {
        return false;

    }

    @Override
    public List takeAllReviews() throws DAOException {
        return null;
    }

    @Override
    public List takeUserReviews(String login) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List reviews = new ArrayList<String>();

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("SELECT title, rating, textReview FROM review INNER JOIN user ON review.idUser = user.idUser INNER JOIN movie ON review.idMovie = movie.idMovie WHERE user.login LIKE ?");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                reviews.add(resultSet.getString(1));
                reviews.add(String.valueOf(resultSet.getInt(2)));
                reviews.add(resultSet.getString(3));
            }

        }catch (ConnectionPoolException e) {
            throw new DAOException("Can't open connection to database yo database",e);
        }catch(SQLException e){
            throw new DAOException("Some problems with your query",e);
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement,resultSet);
        }
        return reviews;
    }


    @Override
    public List findReviewsByMovies(Movie movie) throws DAOException {
        return null;
    }
}
