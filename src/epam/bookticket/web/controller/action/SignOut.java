package epam.bookticket.web.controller.action;

import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignOut extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String adminname = (String)session.getAttribute("adminname");
        String username = (String)session.getAttribute("username");
        if(username!= null || adminname!= null)
        {
            //request.setAttribute("adminname", null);
            //request.setAttribute("username", null);
            session.invalidate();
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
