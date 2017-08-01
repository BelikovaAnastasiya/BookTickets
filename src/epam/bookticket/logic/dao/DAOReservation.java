package epam.bookticket.logic.dao;

import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOReservation {
    boolean addReservation(Reservation reservation)throws DAOException;
    boolean deleteReservation(Reservation reservation)throws DAOException;
    List takeAllReservationByUser(String login)throws DAOException;
}
