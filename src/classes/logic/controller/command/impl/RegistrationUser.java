package classes.logic.controller.command.impl;

import classes.logic.bean.User;
import classes.logic.controller.command.Command;
import classes.logic.service.UserService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class RegistrationUser implements Command {
    @Override
    public String execute(String request) {
        ///формирование объекта
        User user = new User();
        String newString = null;
        String response = null;
        newString = request.substring(request.indexOf(' ')+1, request.length());
        String[] information = newString.split(",");

        user.setIsAdmin(0);
        user.setLogin(information[0]);
        user.setPassword(information[1]);
        user.setMail(information[2]);
        user.setName(information[3]);
        user.setSurname(information[4]);
        user.setNumberCreditCard(information[5]);
        user.setPhone(information[6]);

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            UserService userService = serviceFactory.getUserService();
            response = userService.registration(user);
        } catch (ServiceException e) {
            e.printStackTrace();
            response = "error";
        }

        return response;
    }

    @Override
    public List executeWithData(String request) {
        return null;
    }
}
