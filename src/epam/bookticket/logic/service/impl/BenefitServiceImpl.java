package epam.bookticket.logic.service.impl;

import epam.bookticket.logic.bean.Benefit;
import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.dao.DAOBenefit;
import epam.bookticket.logic.dao.exception.DAOException;
import epam.bookticket.logic.dao.factory.DAOFactory;
import epam.bookticket.logic.service.BenefitService;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public class BenefitServiceImpl implements BenefitService {

    @Override
    public boolean addBenefit(Benefit benefit) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOBenefit daoBenefit = daoFactory.getBenefitDAO();
            return daoBenefit.addBenefit(benefit);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public boolean addBenefitToUser(Benefit benefit, User user) throws ServiceException {
        return false;
    }


    @Override
    public List takeAllBenefits() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOBenefit daoBenefit = daoFactory.getBenefitDAO();
            return daoBenefit.takeAllBenefits();

        }catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteBenefit(String name) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOBenefit daoBenefit = daoFactory.getBenefitDAO();
            return daoBenefit.deleteBenefit(name);
        }catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
