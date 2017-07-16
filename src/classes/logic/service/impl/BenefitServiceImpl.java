package classes.logic.service.impl;

import classes.logic.bean.Benefit;
import classes.logic.bean.User;
import classes.logic.dao.DAOBenefit;
import classes.logic.dao.exception.DAOException;
import classes.logic.dao.factory.DAOFactory;
import classes.logic.service.BenefitService;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public class BenefitServiceImpl implements BenefitService {

    @Override
    public String addBenefit(Benefit benefit) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOBenefit daoBenefit = daoFactory.getBenefitDAO();
            return daoBenefit.addBenefit(benefit);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void addBenefitToUser(Benefit benefit, User user) throws ServiceException {

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
    public String deleteBenefit(String name) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOBenefit daoBenefit = daoFactory.getBenefitDAO();
            return daoBenefit.deleteBenefit(name);
        }catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
