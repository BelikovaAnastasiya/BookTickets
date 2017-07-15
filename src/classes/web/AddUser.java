package classes.web;

import classes.logic.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddUser extends HttpServlet {

    public AddUser()
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
        HttpSession session = request.getSession();
        String sessionAttribute = (String)session.getAttribute("adminname");

       if(request.getParameter("save")!=null)
       {
           char param = ',';
           request.setCharacterEncoding("UTF-8");
           Controller controller = new Controller();
           String toSend = "registration " + request.getParameter("login")+ param + request.getParameter("password")+
                   param + request.getParameter("mail") + param + request.getParameter("name")
                   +param + request.getParameter("surname") + param + request.getParameter("card") + param
                   + request.getParameter("phone"); ///
           String answer = controller.executeTask(toSend);


           if (answer.substring(0,answer.indexOf(' ')).equals("success"))
           {
               if(sessionAttribute == null) {
                   request.getRequestDispatcher("/personalPage.jsp").forward(request, response);
               }
               else
               {
                   request.getRequestDispatcher("/personalPageAdmin.jsp").forward(request,response);
               }
           }
           else
           {
               request.setAttribute("error", "Uncorrect personal information!");
               request.getRequestDispatcher("/error.jsp").forward(request,response);
           }

       }
        else if (request.getParameter("cancel")!=null) {

           if (sessionAttribute == null) {
               request.getRequestDispatcher("/index.jsp").forward(request, response);
           } else {
               RequestDispatcher dispatcher = request.getRequestDispatcher("/personalPageAdmin.jsp");
               dispatcher.forward(request, response);
           }
       }
    }
}
