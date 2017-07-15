package classes.logic.dao;


import classes.logic.bean.Movie;
import classes.logic.bean.Review;
import classes.logic.dao.exception.DAOException;

import java.util.List;


public interface DAOReview {
    void addReview(Review review)throws DAOException;
    void deleteReview(Review review) throws DAOException;
    List takeAllReviews()throws DAOException;
    List takeUserReviews(String login)throws DAOException;
    List findReviewsByMovies(Movie movie)throws DAOException;
}
