package classes.logic.dao;

import classes.logic.bean.Reservation;
import classes.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOReservation {
    String addReservation(Reservation reservation)throws DAOException;
    String deleteReservation(Reservation reservation)throws DAOException;
    List takeAllReservationByUser(String login)throws DAOException;
    List takeAllReservation()throws DAOException;
}
