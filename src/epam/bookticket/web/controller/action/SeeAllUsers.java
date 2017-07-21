package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.service.UserService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeeAllUsers extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<User> userList = new ArrayList<>();

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            userList = userService.takeUsers();

            if (userList.isEmpty())
            {
                String message = "No users in the system";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/WEB-INF/jsp/errorAdmin.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("users", userList);
                request.getRequestDispatcher("/WEB-INF/jsp/allUsers.jsp").forward(request, response);
            }
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
