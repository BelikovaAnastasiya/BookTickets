package classes.web;

import classes.logic.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddMovie extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        if(request.getParameter("save")!=null) {
            char param = '-';
            request.setCharacterEncoding("UTF-8");
            Controller controller = new Controller();
            String toSend = "add_movie " + request.getParameter("title") + param + request.getParameter("year") +
                    param + request.getParameter("type") + param + request.getParameter("actors");
            String answer = controller.executeTask(toSend);

            if (answer.substring(0,answer.indexOf(' ')).equals("success"))
            {
                request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("error", "Uncorrect information about this movie!");
                request.getRequestDispatcher("/error.jsp").forward(request,response);
            }
        }
        else
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/personalPageAdmin.jsp");
            dispatcher.forward(request, response);
        }

    }
}
