package epam.bookticket.logic.service.impl;

import epam.bookticket.logic.bean.Movie;
import epam.bookticket.logic.dao.DAOMovie;
import epam.bookticket.logic.dao.exception.DAOException;
import epam.bookticket.logic.dao.factory.DAOFactory;
import epam.bookticket.logic.service.MovieService;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public class MovieServiceImpl implements MovieService
{
    @Override
    public Boolean addMovie(Movie movie) throws ServiceException {

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
