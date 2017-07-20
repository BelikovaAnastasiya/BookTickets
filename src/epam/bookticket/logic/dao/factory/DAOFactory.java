package epam.bookticket.logic.dao.factory;


import epam.bookticket.logic.dao.*;
import epam.bookticket.logic.dao.impl.*;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final DAOBenefit sqlBenefit = new SQLBenefitDAO();
    private final DAOMovie sqlMovie = new SQLMovieDAO();
    private final DAOReservation sqlReservation = new SQLReservationDAO();
    private final DAOReview sqlReview = new SQLReviewDAO();
    private final DAOUser sqlUser = new SQLUserDAO();

    public DAOFactory() {
    }

    public static DAOFactory getInstance()
    {
        return instance;
    }

    public DAOBenefit getBenefitDAO()
    {
        return sqlBenefit;
    }

    public DAOMovie getMovieDAO()
    {
        return sqlMovie;
    }

    public DAOReservation getReservationDAO()
    {
        return sqlReservation;
    }

    public DAOReview getReviewDAO()
    {
        return sqlReview;
    }

    public DAOUser getUserDAO()
    {
        return sqlUser;
    }

}
