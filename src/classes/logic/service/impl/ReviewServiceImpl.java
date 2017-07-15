package classes.logic.service.impl;

import classes.logic.bean.Review;
import classes.logic.dao.DAOReview;
import classes.logic.dao.exception.DAOException;
import classes.logic.dao.factory.DAOFactory;
import classes.logic.service.ReviewService;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Override
    public void addReview(Review review) throws ServiceException {

    }

    @Override
    public void deleteReview(Review review) throws ServiceException {

    }

    @Override
    public void changeTextReview(Review review, String newText) throws ServiceException {

    }

    @Override
    public void changeRatingReview(Review review, int newRating) throws ServiceException {

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
