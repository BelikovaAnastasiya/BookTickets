package classes.web.controller.action;

import classes.logic.bean.Movie;
import classes.logic.service.MovieService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMovie extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("save")!=null) {
            request.setCharacterEncoding("UTF-8");
            Movie movie = new Movie();
            movie.setTitle(request.getParameter("title"));
            movie.setYearOfProduction(Integer.valueOf(request.getParameter("year")));
            movie.setType(request.getParameter("type"));
            movie.setMainActors(request.getParameter("actors"));
            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                MovieService movieService = serviceFactory.getMovieService();
                Boolean answer = movieService.addMovie(movie);

            if (answer == true)
            {
                request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("error", "Uncorrect information about this movie!");
                request.getRequestDispatcher("/error.jsp").forward(request,response);
            }
            }catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/personalPageAdmin.jsp");
            dispatcher.forward(request, response);
        }

    }
}
