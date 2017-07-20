package classes.logic.dao.impl;


import classes.logic.bean.Movie;
import classes.logic.dao.connectionPool.ConnectionPool;
import classes.logic.dao.connectionPool.exception.ConnectionPoolException;
import classes.logic.dao.DAOMovie;
import classes.logic.dao.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLMovieDAO implements DAOMovie {

    private static ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
    private String query = "SELECT title, yearOfProduction,type, mainActors FROM movie";

    public SQLMovieDAO()
    {
        try {
            connectionPool.initPool();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean addMovie(Movie movie) throws DAOException {
        PreparedStatement preparedStatement = null;
        Connection connection = null;
        Boolean response = false;

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO movie(title,yearOfProduction,type,mainActors) VALUES (?,?,?,?)");
            preparedStatement.setString(1,movie.getTitle());
            preparedStatement.setInt(2,movie.getYearOfProduction());
            preparedStatement.setString(3, movie.getType());
            preparedStatement.setString(4, movie.getMainActors());

            int result = preparedStatement.executeUpdate();
            if(result == 1)
            {
                response = true;
            }

        }catch (ConnectionPoolException|SQLException e) {
            e.printStackTrace();
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement);
        }
        return response;
    }

    @Override
    public String changeInfByMovie(Movie movie, String newInf) throws DAOException {
        return null;
    }

    @Override
    public String deleteMovie(Movie movie) throws DAOException {
        return null;
    }


    @Override
    public List findMovieByTitle(String title) throws DAOException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        List movies = new ArrayList<Movie>();

        try{
            connection = connectionPool.takeConnection();
            preparedStatement = connection.prepareStatement(query + " WHERE title LIKE ?");
            preparedStatement.setString(1, "%" + title + "%");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Movie movie = new Movie();
                movie.setTitle(resultSet.getString(1));
                movie.setYearOfProduction(resultSet.getInt(2));
                movie.setType(resultSet.getString(3));
                movie.setMainActors(resultSet.getString(4));
                movies.add(movie);
            }

        }catch (ConnectionPoolException|SQLException e) {
            e.printStackTrace();
        }
        finally {
            connectionPool.closeConnection(connection,preparedStatement,resultSet);
        }
        return movies;
    }

    @Override
    public List takeAllMovies() throws DAOException {
        Statement st = null;
        ResultSet rs = null;
        Connection connection = null;
        List movies = new ArrayList<Movie>();

        try{
            connection = connectionPool.takeConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while(rs.next())
            {
                Movie movie = new Movie();
                movie.setTitle(rs.getString(1));
                movie.setYearOfProduction(rs.getInt(2));
                movie.setType(rs.getString(3));
                movie.setMainActors(rs.getString(4));
                movies.add(movie);
            }

        } catch (ConnectionPoolException|SQLException e) {
            e.printStackTrace();
        }
        finally {
            connectionPool.closeConnection(connection,st,rs);
        }
        return movies;
    }
}
