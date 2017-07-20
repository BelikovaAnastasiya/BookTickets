package classes.logic.service;

import classes.logic.bean.Benefit;
import classes.logic.bean.User;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public interface BenefitService {

    Boolean addBenefit(Benefit benefit) throws ServiceException;
    Boolean addBenefitToUser(Benefit benefit, User user) throws ServiceException;
    List takeAllBenefits() throws ServiceException;
    Boolean deleteBenefit(String name) throws ServiceException;
}
