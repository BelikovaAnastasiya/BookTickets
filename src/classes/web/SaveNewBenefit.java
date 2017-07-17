package classes.web;

import classes.logic.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveNewBenefit extends HttpServlet {

    public SaveNewBenefit()
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

        if(request.getParameter("save")!=null)
        {
            char param = '-';
            request.setCharacterEncoding("UTF-8");
            Controller controller = new Controller();
            String toSend = "add_benefit " + request.getParameter("title")+ param + request.getParameter("size");
            String answer = controller.executeTask(toSend);


            if (answer.substring(0,answer.indexOf(' ')).equals("success"))
            {
                    request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("error", "Some problems with saving!");
                request.getRequestDispatcher("/error.jsp").forward(request,response);
            }

        }
        else if (request.getParameter("cancel")!=null) {

                RequestDispatcher dispatcher = request.getRequestDispatcher("/personalPageAdmin.jsp");
                dispatcher.forward(request, response);
        }
    }
}
