package classes.web;

import classes.logic.bean.User;
import classes.logic.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeeAllUsers extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");
        Controller controller = new Controller();
        List<User> userList = new ArrayList<>();

        userList = controller.executeTaskWithData("see_users ");

        if (userList.isEmpty())
        {
            String message = "No users in the system";
            request.setAttribute("error", message);
            request.getRequestDispatcher("/errorAdmin.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("users", userList);
            request.getRequestDispatcher("allUsers.jsp").forward(request, response);
        }
    }
}
