package classes.web.controller.action;

import classes.logic.bean.Benefit;
import classes.logic.service.BenefitService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveNewBenefit extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        if(request.getParameter("save")!=null)
        {
            request.setCharacterEncoding("UTF-8");
            Boolean answer;
            Benefit benefit = new Benefit();
            benefit.setTypeBenefit(request.getParameter("title"));
            benefit.setSizeBenefit(Integer.valueOf(request.getParameter("size")));
            try{
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                BenefitService benefitService = serviceFactory.getBenefitService();
                answer = benefitService.addBenefit(benefit);

                if (answer)
                {
                    request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request,response);
                }
                else
                {
                    request.setAttribute("error", "Some problems with saving!");
                    request.getRequestDispatcher("/error.jsp").forward(request,response);
                }
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
        else if (request.getParameter("cancel")!=null) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/personalPageAdmin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
