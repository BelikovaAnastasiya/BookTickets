package epam.bookticket.logic.service;

import epam.bookticket.logic.bean.Benefit;
import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public interface BenefitService {

    Boolean addBenefit(Benefit benefit) throws ServiceException;
    Boolean addBenefitToUser(Benefit benefit, User user) throws ServiceException;
    List takeAllBenefits() throws ServiceException;
    Boolean deleteBenefit(String name) throws ServiceException;
}
