package classes.web.controller.action;

import classes.logic.bean.User;
import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddUser extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sessionAttribute = (String)session.getAttribute("adminname");

        if(request.getParameter("save")!=null)
        {
            request.setCharacterEncoding("UTF-8");
            Boolean answer = false;
            User user = new User();
            user.setIsAdmin(0);
            user.setLogin(request.getParameter("login"));
            user.setPassword(request.getParameter("password"));
            user.setMail(request.getParameter("mail"));
            user.setName(request.getParameter("name"));
            user.setSurname(request.getParameter("surname"));
            user.setNumberCreditCard(request.getParameter("card"));
            user.setPhone(request.getParameter("phone"));

            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                UserService userService = serviceFactory.getUserService();
                answer = userService.registration(user);

                if (answer == true)
                {
                    if(sessionAttribute == null) {
                        request.getRequestDispatcher("/personalPage.jsp").forward(request, response);
                    }
                    else
                    {
                        request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request,response);
                    }
                }
                else
                {
                    request.setAttribute("error", "Uncorrect personal information!");
                    request.getRequestDispatcher("/error.jsp").forward(request,response);
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }


        }
        else if (request.getParameter("cancel")!=null) {

            if (sessionAttribute == null) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/personalPageAdmin.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}