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
                String message = "Ќе найдено фильмов с таким названием!";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("m", movies);
                if (sessionAttribute == null) {
                    request.getRequestDispatcher("/WEB-INF/jsp/searchMovieMainPage.jsp").forward(request, response);
                }
                else
                {
                    request.getRequestDispatcher("/WEB-INF/jsp/allMoviesUser.jsp").forward(request, response);
                }
            }
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }


    }
}
