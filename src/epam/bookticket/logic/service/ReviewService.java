package epam.bookticket.logic.service;

import epam.bookticket.logic.bean.Review;
import epam.bookticket.logic.service.exception.ServiceException;

import java.util.List;

public interface ReviewService {

    boolean addReview(Review review)throws ServiceException;
    boolean deleteReview(Review review)throws ServiceException;
    List takeAllReviews()throws ServiceException;
    List takeUserReviews(String login) throws ServiceException;
    /// and others
}
