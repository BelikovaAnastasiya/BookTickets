package classes.logic.controller.command.impl;

import classes.logic.bean.Movie;
import classes.logic.controller.command.Command;
import classes.logic.service.MovieService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class AddMovie implements Command {
    @Override
    public String execute(String request) {
        Movie movie = new Movie();
        String newString = null;
        String response = null;
        newString = request.substring(request.indexOf(' ')+1, request.length());
        String[] information = newString.split("-");

        movie.setTitle(information[0]);
        movie.setYearOfProduction(Integer.valueOf(information[1]));
        movie.setType(information[2]);
        movie.setMainActors(information[3]);

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            MovieService movieService = serviceFactory.getMovieService();
            response = movieService.addMovie(movie);
        }catch (ServiceException e) {
            e.printStackTrace();
            response = "error ";
        }
        return response;
    }

    @Override
    public List executeWithData(String request) {
        return null;
    }
}
