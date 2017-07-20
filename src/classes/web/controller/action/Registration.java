package classes.web.controller.action;

import classes.web.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        if (request.getParameter("login")!=null){
            CheckUser checkUser = new CheckUser();
            checkUser.execute(request,response,request.getServletContext());

        } else if (request.getParameter("registration")!=null) {
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/registration.jsp");
            dispatcher.forward(request, response);
        }
    }
}
