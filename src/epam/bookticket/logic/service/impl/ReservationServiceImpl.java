package epam.bookticket.logic.service.impl;

import epam.bookticket.logic.bean.Reservation;
import epam.bookticket.logic.dao.DAOReservation;
import epam.bookticket.logic.dao.exception.DAOException;
import epam.bookticket.logic.dao.factory.DAOFactory;
import epam.bookticket.logic.service.ReservationService;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    @Override
    public boolean addReservation(Reservation reservation) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOReservation daoReservation = daoFactory.getReservationDAO();
            return  daoReservation.addReservation(reservation);
        }
        catch (DAOException e)
        {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteReservation(Reservation reservation) throws ServiceException {
        return false;

    }

    @Override
    public List takeAllReservationByUser(String login) throws ServiceException {

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOReservation daoReservation = daoFactory.getReservationDAO();
            return  daoReservation.takeAllReservationByUser(login);
        }
        catch (DAOException e)
        {
            throw new ServiceException(e);
        }
    }
}
