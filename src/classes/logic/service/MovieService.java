package classes.logic.service;

import classes.logic.bean.Movie;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public interface MovieService {

    Boolean addMovie(Movie movie)throws ServiceException;
    String changeInfByMovie(Movie movie, String newInf)throws ServiceException;
    String deleteMovie(Movie movie)throws ServiceException;
    List takeAllMovies()throws ServiceException;
    List findMovieByName(String name) throws ServiceException;

}
