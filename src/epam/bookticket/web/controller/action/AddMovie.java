package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Movie;
import epam.bookticket.logic.service.MovieService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddMovie extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("adminname");
        if(name == null)
        {
            request.setAttribute("error", "Вы не авторизированны!");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
        else
        {
            if (request.getParameter("save") != null) {
                request.setCharacterEncoding("UTF-8");
                Movie movie = new Movie();
                movie.setTitle(request.getParameter("title"));
                movie.setYearOfProduction(Integer.valueOf(request.getParameter("year")));
                movie.setType(request.getParameter("type"));
                movie.setMainActors(request.getParameter("actors"));
                try {
                    ServiceFactory serviceFactory = ServiceFactory.getInstance();
                    MovieService movieService = serviceFactory.getMovieService();
                    boolean answer = movieService.addMovie(movie);

                    if (answer) {
                        request.getRequestDispatcher("/WEB-INF/jsp/personalPageAdmin.jsp").forward(request, response);
                    } else {
                        request.setAttribute("error", "Некорректная информация о фильме!");
                        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                    }
                } catch (ServiceException e) {

                    request.setAttribute("error", e.getMessage());
                    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                }
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalPageAdmin.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
