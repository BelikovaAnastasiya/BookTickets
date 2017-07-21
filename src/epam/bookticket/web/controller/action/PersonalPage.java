package epam.bookticket.web.controller.action;

import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class PersonalPage extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionAttribute = (String)session.getAttribute("username");
        if(sessionAttribute == null)
        {
            request.getRequestDispatcher("/WEB-INF/jsp/personalPageAdmin.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp").forward(request,response);
        }
    }
}
