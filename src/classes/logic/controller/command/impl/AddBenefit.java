package classes.logic.controller.command.impl;

import classes.logic.bean.Benefit;
import classes.logic.controller.command.Command;
import classes.logic.service.BenefitService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class AddBenefit implements Command {
    @Override
    public String execute(String request) {
        Benefit benefit = new Benefit();
        String response = "error ";
        String newString = request.substring(request.indexOf(' ')+1, request.length());
        String[] information = newString.split("^");

        benefit.setTypeBenefit(information[0]);
        benefit.setSizeBenefit(Integer.valueOf(information[1]));
        try{
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BenefitService benefitService = serviceFactory.getBenefitService();
            return benefitService.addBenefit(benefit);
        } catch (ServiceException e) {
            e.printStackTrace();
            return response;
        }
    }

    @Override
    public List executeWithData(String request) {
        return null;
    }
}
