package epam.bookticket.web.controller.action;

import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMovieAdmin extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/jsp/addMovie.jsp").forward(request,response);
    }
}
