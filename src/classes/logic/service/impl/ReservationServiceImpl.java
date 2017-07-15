package classes.logic.service.impl;

import classes.logic.bean.Reservation;
import classes.logic.dao.DAOReservation;
import classes.logic.dao.exception.DAOException;
import classes.logic.dao.factory.DAOFactory;
import classes.logic.service.ReservationService;
import classes.logic.service.exception.ServiceException;

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
