package classes.web;

import classes.logic.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyProfile extends HttpServlet {

    public MyProfile(){

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {

        request.setCharacterEncoding("UTF-8");
        Controller controller = new Controller();
        String profile = null;
        profile = controller.executeTask("my_profile " + request.getSession().getAttribute("username"));


        if (profile.substring(0,profile.indexOf(' ')).equals("success"))
        {
            String newString = profile.substring(profile.indexOf(' ')+1, profile.length());
            String[] information = newString.split(",");
            request.setAttribute("login", information[0]);
            request.setAttribute("password", information[1]);
            request.setAttribute("mail", information[2]);
            request.setAttribute("name", information[3]);
            request.setAttribute("surname", information[4]);
            request.setAttribute("numberCreditCard", information[5]);
            request.setAttribute("phone", information[6]);
            request.setAttribute("benefit", information[7]);

            request.getRequestDispatcher("/userProfile.jsp").forward(request, response);
        }
        else
        {
            String message = "Error with profile information!!";
            request.setAttribute("error", message);
            request.getRequestDispatcher("/errorUser.jsp").forward(request,response);
        }

    }
}
