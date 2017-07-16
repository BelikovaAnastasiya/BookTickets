package classes.logic.service;

import classes.logic.bean.Benefit;
import classes.logic.bean.User;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public interface BenefitService {

    String addBenefit(Benefit benefit) throws ServiceException;
    void addBenefitToUser(Benefit benefit, User user) throws ServiceException;
    List takeAllBenefits() throws ServiceException;
    String deleteBenefit(String name) throws ServiceException;
}
