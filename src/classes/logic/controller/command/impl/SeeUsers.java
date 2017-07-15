package classes.logic.controller.command.impl;

import classes.logic.controller.command.Command;
import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class SeeUsers implements Command {
    @Override
    public String execute(String request) {
        return "empty ";
    }

    @Override
    public List executeWithData(String request) {
        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            return userService.takeUsers();
        } catch (ServiceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
