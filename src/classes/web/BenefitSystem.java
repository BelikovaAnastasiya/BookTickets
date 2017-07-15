package classes.web;

import classes.logic.bean.Benefit;
import classes.logic.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BenefitSystem extends HttpServlet {

    public BenefitSystem(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
    {
        request.setCharacterEncoding("UTF-8");
        Controller controller = new Controller();
        List benefits = new ArrayList<Benefit>();
        benefits = controller.executeTaskWithData("see_all_benefit ");

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
    }
}
