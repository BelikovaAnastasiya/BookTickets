package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.service.ReservationService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeeBooking extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Reservation> reservations = new ArrayList<Reservation>();

        try{
            String login = (String)request.getSession().getAttribute("username");
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ReservationService reservationService = serviceFactory.getReservationService();
            reservations = reservationService.takeAllReservationByUser(login);

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
        }catch (ServiceException e)
        {
            e.printStackTrace();
        }
    }
}
