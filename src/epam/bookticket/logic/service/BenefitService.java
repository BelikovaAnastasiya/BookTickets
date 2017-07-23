package epam.bookticket.logic.service;

import epam.bookticket.logic.bean.Benefit;
import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public interface BenefitService {

    boolean addBenefit(Benefit benefit) throws ServiceException;
    boolean addBenefitToUser(Benefit benefit, User user) throws ServiceException;
    List takeAllBenefits() throws ServiceException;
    boolean deleteBenefit(String name) throws ServiceException;
}
