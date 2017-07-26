package epam.bookticket.logic.service.impl;

import epam.bookticket.logic.bean.Review;
import epam.bookticket.logic.dao.DAOReview;
import epam.bookticket.logic.dao.exception.DAOException;
import epam.bookticket.logic.dao.factory.DAOFactory;
import epam.bookticket.logic.service.ReviewService;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {


    @Override
    public boolean addReview(Review review) throws ServiceException {
        try{
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOReview daoReview = daoFactory.getReviewDAO();
            return daoReview.addReview(review);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteReview(Review review) throws ServiceException {
        return false;
    }

    @Override
    public List takeAllReviews() throws ServiceException {
        return null;
    }

    @Override
    public List takeUserReviews(String login) throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            DAOReview daoReview = daoFactory.getReviewDAO();
            return daoReview.takeUserReviews(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
