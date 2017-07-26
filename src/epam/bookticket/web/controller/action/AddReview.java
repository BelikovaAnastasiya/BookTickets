package epam.bookticket.web.controller.action;

import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddReview extends BaseController {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("username");
        if(name == null)
        {
            request.setAttribute("error", "You are not authentication user!");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/addReview.jsp").forward(request, response);
        }
    }
}
