package classes.logic.controller.command.impl;

import classes.logic.controller.command.Command;
import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String login = null;
        String password = null;
        String response = "error ";

        login = request.substring(request.indexOf(' ')+1, request.indexOf(','));
        password =  request.substring(request.indexOf(',')+1, request.length());


        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            response = userService.signIn(login,password);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public List executeWithData(String request) {
        return null;
    }
}
