package classes.web.controller.action;

import classes.logic.bean.Movie;
import classes.logic.service.MovieService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindFilm extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String sessionAttribute = (String)session.getAttribute("username");
        List<Movie> movies = new ArrayList<Movie>();

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            MovieService movieService = serviceFactory.getMovieService();
            movies = movieService.findMovieByName(request.getParameter("search"));

            if (movies.isEmpty())
            {
                String message = "No movies with that title";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/error.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("m", movies);
                if (sessionAttribute == null) {
                    request.getRequestDispatcher("/searchMovieMainPage.jsp").forward(request, response);
                }
                else
                {
                    request.getRequestDispatcher("/allMoviesUser.jsp").forward(request, response);
                }
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
