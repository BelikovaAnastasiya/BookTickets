package epam.bookticket.logic.dao;

import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOReservation {
    String addReservation(Reservation reservation)throws DAOException;
    String deleteReservation(Reservation reservation)throws DAOException;
    List takeAllReservationByUser(String login)throws DAOException;
    List takeAllReservation()throws DAOException;
}
