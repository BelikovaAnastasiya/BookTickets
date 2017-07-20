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
    public void addReservation(Reservation reservation) throws ServiceException {

    }

    @Override
    public void deleteReservation(Reservation reservation) throws ServiceException {

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
