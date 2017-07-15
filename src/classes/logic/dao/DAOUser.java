package classes.logic.dao;


import classes.logic.bean.User;
import classes.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOUser {
    String sighIn(String login, String password) throws DAOException;
    String registration(User user)throws DAOException;
    String takeProfileInformation(String login) throws DAOException;
    void deleteUser(User user)throws DAOException;
    void editInformationAboutUser(User user, String newInformation)throws DAOException;
    List takeAllUsers()throws DAOException;
}
