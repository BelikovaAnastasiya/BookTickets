package classes.logic.service;

import classes.logic.bean.Review;
import classes.logic.service.exception.ServiceException;

import java.util.List;

public interface ReviewService {

    void addReview(Review review)throws ServiceException;
    void deleteReview(Review review)throws ServiceException;
    void changeTextReview(Review review, String newText)throws ServiceException;
    void changeRatingReview(Review review, int newRating)throws ServiceException;
    List takeAllReviews()throws ServiceException;
    List takeUserReviews(String login) throws ServiceException;
    /// and others
}
