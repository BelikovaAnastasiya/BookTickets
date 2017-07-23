package epam.bookticket.logic.dao;


import epam.bookticket.logic.bean.Movie;
import epam.bookticket.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOMovie {
    boolean addMovie(Movie movie) throws DAOException;
    String changeInfByMovie(Movie movie, String newInf) throws DAOException;
    String deleteMovie(Movie movie)throws DAOException;
    List findMovieByTitle(String title) throws DAOException;
    List takeAllMovies() throws DAOException;
}
