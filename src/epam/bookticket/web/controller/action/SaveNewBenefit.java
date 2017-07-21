package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Benefit;
import epam.bookticket.logic.service.BenefitService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

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
                    request.getRequestDispatcher("/WEB-INF/jsp/personalPageAdmin.jsp").forward(request,response);
                }
                else
                {
                    request.setAttribute("error", "Some problems with saving!");
                    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
                }
            } catch (ServiceException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
            }
        }
        else if (request.getParameter("cancel")!=null) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalPageAdmin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
