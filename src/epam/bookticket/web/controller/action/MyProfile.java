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

public class MyProfile extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        String name = (String)session.getAttribute("username");

        if(name == null)
        {
            request.setAttribute("error", "Вы не аутентифицированы!");
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
        else {
            request.setCharacterEncoding("UTF-8");
            String profile = null;
            String login = (String) request.getSession().getAttribute("username");

            try {

                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                UserService userService = serviceFactory.getUserService();
                profile = userService.takeUserInformation(login);

                if (profile.substring(0, profile.indexOf(' ')).equals("success")) {
                    String newString = profile.substring(profile.indexOf(' ') + 1, profile.length());
                    String[] information = newString.split(",");
                    request.setAttribute("login", information[0]);
                    request.setAttribute("password", information[1]);
                    request.setAttribute("mail", information[2]);
                    request.setAttribute("name", information[3]);
                    request.setAttribute("surname", information[4]);
                    request.setAttribute("numberCreditCard", information[5]);
                    request.setAttribute("phone", information[6]);
                    request.setAttribute("benefit", information[7]);

                    request.getRequestDispatcher("/WEB-INF/jsp/userProfile.jsp").forward(request, response);
                } else {
                    String message = "Возникла ошибка с предоставлением ваших персональных данных!";
                    request.setAttribute("error", message);
                    request.getRequestDispatcher("/WEB-INF/jsp/errorUser.jsp").forward(request, response);
                }
            } catch (ServiceException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
            }
        }
    }
}
