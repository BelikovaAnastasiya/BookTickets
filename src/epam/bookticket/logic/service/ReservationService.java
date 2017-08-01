package epam.bookticket.logic.service;

import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public interface ReservationService {

    boolean addReservation(Reservation reservation)throws ServiceException;
    boolean deleteReservation(Reservation reservation)throws ServiceException;
    List takeAllReservationByUser (String login) throws ServiceException;
    //void changeReservation and others
}
