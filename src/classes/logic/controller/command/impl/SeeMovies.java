package classes.logic.controller.command.impl;

import classes.logic.controller.command.Command;
import classes.logic.service.MovieService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class SeeMovies implements Command {
    @Override
    public String execute(String request) {
        return "empty";
    }

    @Override
    public List executeWithData(String request) {

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            MovieService movieService = serviceFactory.getMovieService();
            return movieService.takeAllMovies();
        } catch (ServiceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
