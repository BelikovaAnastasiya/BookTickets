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
