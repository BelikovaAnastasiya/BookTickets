package epam.bookticket.web.controller.action;

import epam.bookticket.logic.service.BenefitService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBenefit extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nameBenefit = request.getParameter("procent");
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BenefitService benefitService = serviceFactory.getBenefitService();
            Boolean result = benefitService.deleteBenefit(nameBenefit);

            if (result == true)
            {
                request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("error", "Can't delete this benefit!");
                request.getRequestDispatcher("/errorAdmin.jsp").forward(request,response);
            }
        }catch (ServiceException e) {
            e.printStackTrace();}

    }
}
