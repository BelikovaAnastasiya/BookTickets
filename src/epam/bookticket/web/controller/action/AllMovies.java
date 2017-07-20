package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Movie;
import epam.bookticket.logic.service.MovieService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AllMovies extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Movie> movies = new ArrayList<Movie>();

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            MovieService movieService = serviceFactory.getMovieService();
            movies = movieService.takeAllMovies();

            if (movies.isEmpty())
            {
                String message = "No movies";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/errorUser.jsp").forward(request,response);
            }
            else
            {
                for(int i=0; i<movies.size(); i++) {
                    request.setAttribute("title", movies.get(i).getTitle());
                    request.setAttribute("yearOfProduction", movies.get(i).getYearOfProduction());
                    request.setAttribute("type", movies.get(i).getType());
                    request.setAttribute("mainActors", movies.get(i).getMainActors());
                    request.setAttribute("m", movies);
                }
                request.getRequestDispatcher("/allMoviesUser.jsp").forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }
}
