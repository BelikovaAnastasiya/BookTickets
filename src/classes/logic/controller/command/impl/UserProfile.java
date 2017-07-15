package classes.logic.controller.command.impl;

import classes.logic.controller.command.Command;
import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class UserProfile implements Command {
    @Override
    public String execute(String request) {

        try {
            String login = request.substring(request.indexOf(' ')+1);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            return userService.takeUserInformation(login);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "error ";
    }

    @Override
    public List executeWithData(String request) {
        return null;
    }
}
