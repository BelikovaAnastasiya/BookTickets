package classes.web;

import classes.logic.bean.Reservation;
import classes.logic.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeeBooking extends HttpServlet {

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
        List<Reservation> reservations = new ArrayList<Reservation>();
        reservations = controller.executeTaskWithData("see_user_reservations " + request.getSession().getAttribute("username"));
        request.setAttribute("user", "All Reservations");

        if (reservations.isEmpty())
        {
            String message = "You don't have reservations!!!";
            request.setAttribute("error", message);
            request.getRequestDispatcher("/errorUser.jsp").forward(request,response);
        }
        else
        {
            request.setAttribute("booking", reservations);
            request.getRequestDispatcher("/userReservation.jsp").forward(request, response);
        }


    }
}
