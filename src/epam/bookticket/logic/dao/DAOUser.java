package epam.bookticket.logic.dao;


import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOUser {
    String signIn(String login, String password) throws DAOException;
    Boolean registration(User user)throws DAOException;
    String takeProfileInformation(String login) throws DAOException;
    void deleteUser(User user)throws DAOException;
    void editInformationAboutUser(User user, String newInformation)throws DAOException;
    List takeAllUsers()throws DAOException;
}
