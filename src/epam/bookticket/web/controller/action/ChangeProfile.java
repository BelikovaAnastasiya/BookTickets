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

public class ChangeProfile extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("username");
        String changeParametr = request.getParameter("param");
        String newValue = request.getParameter("value");

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            boolean result = userService.editInformationAboutUser(login, changeParametr, newValue);
            if (result) {
                request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Проблемы с измененем данных. Попробуйте позже!");
                request.getRequestDispatcher("/WEB-INF/jsp/errorUser.jsp").forward(request, response);
            }
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/errorUser.jsp").forward(request, response);
        }
    }
}
