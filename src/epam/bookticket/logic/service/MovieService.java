package epam.bookticket.logic.service;

import epam.bookticket.logic.bean.Movie;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public interface MovieService {

    boolean addMovie(Movie movie)throws ServiceException;
    String changeInfByMovie(Movie movie, String newInf)throws ServiceException;
    String deleteMovie(Movie movie)throws ServiceException;
    List takeAllMovies()throws ServiceException;
    List findMovieByName(String name) throws ServiceException;

}
