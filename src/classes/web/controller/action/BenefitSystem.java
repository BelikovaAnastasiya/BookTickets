package classes.web.controller.action;

import classes.logic.bean.Benefit;
import classes.logic.service.BenefitService;
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

public class BenefitSystem extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List benefits = new ArrayList<Benefit>();

        try{
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BenefitService benefitService = serviceFactory.getBenefitService();
            benefits =  benefitService.takeAllBenefits();

            if(benefits.isEmpty())
            {
                String message = "No benefits in this system!";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/errorAdmin.jsp").forward(request,response);
            }
            else
            {

                request.setAttribute("benefits", benefits);
                request.getRequestDispatcher("/allBenefit.jsp").forward(request,response);

            }

        }catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
