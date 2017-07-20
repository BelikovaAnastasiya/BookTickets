package epam.bookticket.logic.service;

import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public interface ReservationService {

    void addReservation(Reservation reservation)throws ServiceException;
    void deleteReservation(Reservation reservation)throws ServiceException;
    List takeAllReservationByUser (String login) throws ServiceException;
    //void changeReservation and others
}
