package epam.bookticket.web.controller.action;

import epam.bookticket.logic.service.UserService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUser extends BaseController{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            boolean result = userService.deleteUser(userName);

            if (result)
            {
                request.getRequestDispatcher("/WEB-INF/jsp/personalPageAdmin.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("error", "Данный тип скидки не был удален!");
                request.getRequestDispatcher("/WEB-INF/jsp/errorAdmin.jsp").forward(request,response);
            }
        }catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
