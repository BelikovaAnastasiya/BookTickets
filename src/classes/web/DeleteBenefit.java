package classes.web;

import classes.logic.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBenefit extends HttpServlet {

    public DeleteBenefit()
    {
        super();
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
        String nameBenefit = request.getParameter("procent");
        String toSend = "delete_benefit " + nameBenefit;
        String answer = controller.executeTask(toSend);

        if (answer.substring(0,answer.indexOf(' ')).equals("success"))
        {
            request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("error", "Can't delete this benefit!");
            request.getRequestDispatcher("/errorAdmin.jsp").forward(request,response);
        }


    }
}
