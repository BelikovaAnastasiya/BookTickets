package epam.bookticket.logic.service.impl;

import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.dao.DAOUser;
import epam.bookticket.logic.dao.exception.DAOException;
import epam.bookticket.logic.dao.factory.DAOFactory;
import epam.bookticket.logic.service.UserService;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public String signIn(String login, String password) throws ServiceException {

        try {
            DAOFactory daoFactoryObject = DAOFactory.getInstance();
            DAOUser daoUser = daoFactoryObject.getUserDAO();
            return daoUser.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean registration(User user) throws ServiceException {
        try {
            DAOFactory daoFactoryObject = DAOFactory.getInstance();
            DAOUser daoUser = daoFactoryObject.getUserDAO();
            return daoUser.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public String deleteUser(User user) throws ServiceException {

        return "eg";
    }

    @Override
    public String takeUserInformation(String login) throws ServiceException {
        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOUser daoUser = daoFactory.getUserDAO();
            return daoUser.takeProfileInformation(login);
        }catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List takeUsers() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOUser daoUser = daoFactory.getUserDAO();
            return daoUser.takeAllUsers();
        }catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean editInformationAboutUser(String login, String parametr, String newInformation) throws ServiceException {
        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOUser daoUser = daoFactory.getUserDAO();
            return daoUser.editInformationAboutUser(login,parametr,newInformation);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
