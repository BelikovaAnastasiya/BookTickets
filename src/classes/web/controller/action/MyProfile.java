package classes.web.controller.action;

import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyProfile extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String profile = null;
        String login = (String)request.getSession().getAttribute("username");

        try {

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            profile = userService.takeUserInformation(login);

            if (profile.substring(0,profile.indexOf(' ')).equals("success"))
            {
                String newString = profile.substring(profile.indexOf(' ')+1, profile.length());
                String[] information = newString.split(",");
                request.setAttribute("login", information[0]);
                request.setAttribute("password", information[1]);
                request.setAttribute("mail", information[2]);
                request.setAttribute("name", information[3]);
                request.setAttribute("surname", information[4]);
                request.setAttribute("numberCreditCard", information[5]);
                request.setAttribute("phone", information[6]);
                request.setAttribute("benefit", information[7]);

                request.getRequestDispatcher("/userProfile.jsp").forward(request, response);
            }
            else
            {
                String message = "Error with profile information!!";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/errorUser.jsp").forward(request,response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }


    }
}