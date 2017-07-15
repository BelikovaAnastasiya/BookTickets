package classes.logic.dao;

import classes.logic.bean.Benefit;
import classes.logic.bean.User;
import classes.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOBenefit {

    String addBenefit(Benefit benefit) throws DAOException;
    String addBenefitToUser(Benefit benefit, User user) throws DAOException;
    List takeAllBenefits() throws DAOException;

}
