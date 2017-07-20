package classes.web.controller.action;

import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

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
                    request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request, response);
                }
                else
                {
                    session.setAttribute("username", request.getParameter("user"));
                    request.getRequestDispatcher("/personalPage.jsp").forward(request, response);
                }
            }
            else
            {
                request.setAttribute("error", "No users with this login and password. Check your information!");
                request.getRequestDispatcher("/error.jsp").forward(request,response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}
