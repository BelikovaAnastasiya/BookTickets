package epam.bookticket.logic.dao;

import epam.bookticket.logic.bean.Benefit;
import epam.bookticket.logic.bean.User;
import epam.bookticket.logic.dao.exception.DAOException;

import java.util.List;

public interface DAOBenefit {

    Boolean addBenefit(Benefit benefit) throws DAOException;
    Boolean addBenefitToUser(Benefit benefit, User user) throws DAOException;
    List takeAllBenefits() throws DAOException;
    Boolean deleteBenefit(String name) throws DAOException;

}
