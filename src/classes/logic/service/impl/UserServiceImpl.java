package classes.logic.service.impl;

import classes.logic.bean.User;
import classes.logic.dao.DAOUser;
import classes.logic.dao.exception.DAOException;
import classes.logic.dao.factory.DAOFactory;
import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public String signIn(String login, String password) throws ServiceException {

        try {
            DAOFactory daoFactoryObject = DAOFactory.getInstance();
            DAOUser daoUser = daoFactoryObject.getUserDAO();
            return daoUser.sighIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public String registration(User user) throws ServiceException {
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
    public String editInformationAboutUser(User user, String newInformation) throws ServiceException {

        return "rht";
    }
}
