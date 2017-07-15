package classes.logic.controller.command.impl;

import classes.logic.controller.command.Command;
import classes.logic.service.ReservationService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class UserReservation implements Command {
    @Override
    public String execute(String request) {
        return "empty ";
    }

    @Override
    public List executeWithData(String request) {
        try{
            String login = request.substring(request.indexOf(' ')+1);
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ReservationService reservationService = serviceFactory.getReservationService();
            return reservationService.takeAllReservationByUser(login);
        }catch (ServiceException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
