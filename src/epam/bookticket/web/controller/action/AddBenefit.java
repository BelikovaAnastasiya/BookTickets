package epam.bookticket.web.controller.action;

import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBenefit extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        if(request.getParameter("addBenefit")!=null)
        {
            request.getRequestDispatcher("/addBenefit.jsp").forward(request,response);
        }
        else
        {
            request.getRequestDispatcher("/setNewBenefitToUser.jsp").forward(request,response);
        }
    }
}
