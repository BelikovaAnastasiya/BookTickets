package classes.logic.service;

import classes.logic.bean.User;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public interface UserService {

    String signIn(String login, String password)throws ServiceException;
    Boolean registration(User user)throws ServiceException;
    String deleteUser(User user)throws ServiceException;
    String takeUserInformation(String login) throws ServiceException;
    List takeUsers() throws ServiceException;
    String editInformationAboutUser(User user, String newInformation)throws ServiceException;///and others
}
