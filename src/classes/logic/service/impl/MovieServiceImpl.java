package classes.logic.service.impl;

import classes.logic.bean.Movie;
import classes.logic.dao.DAOMovie;
import classes.logic.dao.exception.DAOException;
import classes.logic.dao.factory.DAOFactory;
import classes.logic.service.MovieService;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public class MovieServiceImpl implements MovieService
{
    @Override
    public String addMovie(Movie movie) throws ServiceException {

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOMovie daoMovie = daoFactory.getMovieDAO();
            return daoMovie.addMovie(movie);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public String changeInfByMovie(Movie movie, String newInf) throws ServiceException {
        return "ulala";
    }

    @Override
    public String deleteMovie(Movie movie) throws ServiceException {
        return "ulala";
    }

    @Override
    public List takeAllMovies() throws ServiceException {
        try {
            DAOFactory daoFactoryObject = DAOFactory.getInstance();
            DAOMovie movieDAO = daoFactoryObject.getMovieDAO();
            return movieDAO.takeAllMovies();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List findMovieByName(String name) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOMovie movie = daoFactory.getMovieDAO();
            return movie.findMovieByTitle(name);
        }catch (DAOException e)
        {
            throw new ServiceException(e);
        }
    }
}
