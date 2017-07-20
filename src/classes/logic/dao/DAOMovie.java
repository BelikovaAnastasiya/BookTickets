package classes.logic.dao;


import classes.logic.bean.Movie;
import classes.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOMovie {
    Boolean addMovie(Movie movie) throws DAOException;
    String changeInfByMovie(Movie movie, String newInf) throws DAOException;
    String deleteMovie(Movie movie)throws DAOException;
    List findMovieByTitle(String title) throws DAOException;
    List takeAllMovies() throws DAOException;
}
