package epam.bookticket.logic.dao;


import epam.bookticket.logic.bean.Movie;
import epam.bookticket.logic.bean.Review;
import epam.bookticket.logic.dao.exception.DAOException;

import java.util.List;


public interface DAOReview {
    boolean addReview(Review review)throws DAOException;
    boolean deleteReview(Review review) throws DAOException;
    List takeAllReviews()throws DAOException;
    List takeUserReviews(String login)throws DAOException;
    List findReviewsByMovies(Movie movie)throws DAOException;
}
