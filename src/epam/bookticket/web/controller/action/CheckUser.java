package epam.bookticket.web.controller.action;

import epam.bookticket.logic.service.UserService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckUser extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");/// подчинить русскую кодировку
        String login = request.getParameter("user");
        String password =  request.getParameter("password");
        String answer = null;

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            answer = userService.signIn(login,password);

            if (answer.substring(0,answer.indexOf(' ')).equals("success"))
            {
                HttpSession session = request.getSession();


                if(answer.substring(answer.indexOf(' ')+1).equals("admin"))
                {
                    session.setAttribute("adminname", request.getParameter("user"));
                    request.getRequestDispatcher("/WEB-INF/jsp/personalPageAdmin.jsp").forward(request, response);
                }
                else
                {
                    session.setAttribute("username", request.getParameter("user"));
                    request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp").forward(request, response);
                }
            }
            else
            {
                request.setAttribute("error", "No users with this login and password. Check your information!");
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
            }
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }


    }
}
