package classes.web.controller.action;

import classes.logic.bean.User;
import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

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
                request.getRequestDispatcher("/errorAdmin.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("users", userList);
                request.getRequestDispatcher("allUsers.jsp").forward(request, response);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
