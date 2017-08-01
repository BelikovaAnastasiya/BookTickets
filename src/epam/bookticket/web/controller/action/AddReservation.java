package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.service.ReservationService;
import epam.bookticket.logic.service.UserService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddReservation extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String login = (String)session.getAttribute("username");

        if(request.getParameter("cancel") != null)
        {
            if (login == null) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp");
                dispatcher.forward(request, response);
            }
        }
        else
        {
            request.setCharacterEncoding("UTF-8");
            boolean answer;
            Reservation reservation = new Reservation();
            reservation.setDate(request.getParameter("date"));

            double price = countPrice(login, Integer.parseInt(request.getParameter("time")),Integer.parseInt(request.getParameter("ticket")), request, response);
            reservation.setPrice(price);
            reservation.setNumberOfTheChair(request.getParameter("chain"));
            reservation.setCountTickets(Integer.parseInt(request.getParameter("ticket")));
            reservation.setCinemaTitle(request.getParameter("param"));
            reservation.setLoginUser(login);
            reservation.setMovieTitle(request.getParameter("movieTitle"));

            if(request.getParameter("save")!=null)
            {
                reservation.setIsPaid(false);
            }
            else
            {
                reservation.setIsPaid(true);
            }

            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                ReservationService reservationService = serviceFactory.getReservationService();
                answer = reservationService.addReservation(reservation);

                if (answer)
                {
                    request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp").forward(request,response);
                }
                else
                {
                    request.setAttribute("error", "Некорректные данные о заказе!");
                    request.getRequestDispatcher("/WEB-INF/jsp/errorUser.jsp").forward(request,response);
                }
            } catch (ServiceException e) {
                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/errorUser.jsp").forward(request,response);
            }
        }
    }

    private double countPrice(String login, int time, int countTicket, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {
            double finalPrice = 0.0;
        try {

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            String profile = userService.takeUserInformation(login);

            if (profile.substring(0, profile.indexOf(' ')).equals("success")) {
                String newString = profile.substring(profile.indexOf(' ') + 1, profile.length());
                String[] information = newString.split(",");
                int benefit = Integer.parseInt(information[7]);
                double timeFactor =  1.2;
                if(time == 1)
                {
                    timeFactor = 1.7;
                }
                if(benefit == 0)
                {
                    finalPrice = timeFactor*countTicket*3.2;
                }
                else
                {
                    finalPrice = ((1 - benefit)/100)*timeFactor*countTicket*3.2;
                }

            } else {
                String message = "Возникла ошибка с предоставлением ваших персональных данных!";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/WEB-INF/jsp/errorUser.jsp").forward(request, response);
            }
        } catch (ServiceException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
        }
        return finalPrice;
    }
}
