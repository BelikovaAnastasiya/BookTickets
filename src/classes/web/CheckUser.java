package classes.web;

import classes.logic.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckUser extends HttpServlet {

    public CheckUser()
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
    {
        request.setCharacterEncoding("UTF-8");/// подчинить русскую кодировку
        Controller controller = new Controller();
        String toSend = "sign_in " + request.getParameter("user") + "," + request.getParameter("password");
        String answer = controller.executeTask(toSend);

        if (answer.substring(0,answer.indexOf(' ')).equals("success"))
        {
            HttpSession session = request.getSession();


            if(answer.substring(answer.indexOf(' ')+1).equals("admin"))
            {
                session.setAttribute("adminname", request.getParameter("user"));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/personalPageAdmin.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                session.setAttribute("username", request.getParameter("user"));
                request.getRequestDispatcher("/personalPage.jsp").forward(request, response);
            }
        }
        else
        {
            request.setAttribute("error", "No users with this login and password. Check your information!");
            request.getRequestDispatcher("/error.jsp").forward(request,response);
        }
    }

}
