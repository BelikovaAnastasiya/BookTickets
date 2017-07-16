package classes.logic.controller.command.impl;

import classes.logic.controller.command.Command;
import classes.logic.service.BenefitService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;

import java.util.List;

public class DeleteBenefitByName implements Command {
    @Override
    public String execute(String request) {
        try{
            String title = request.substring(request.indexOf(' ')+1);

            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            BenefitService benefitService = serviceFactory.getBenefitService();
            return benefitService.deleteBenefit(title);
        } catch (ServiceException e) {
            e.printStackTrace();
            return "error ";
        }
    }

    @Override
    public List executeWithData(String request) {
        return null;
    }
}
