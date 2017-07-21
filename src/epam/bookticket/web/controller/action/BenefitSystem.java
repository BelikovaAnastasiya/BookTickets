package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Benefit;
import epam.bookticket.logic.service.BenefitService;
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
                request.getRequestDispatcher("/WEB-INF/jsp/errorAdmin.jsp").forward(request,response);
            }
            else
            {

                request.setAttribute("benefits", benefits);
                request.getRequestDispatcher("/WEB-INF/jsp/allBenefit.jsp").forward(request,response);

            }

        }catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
