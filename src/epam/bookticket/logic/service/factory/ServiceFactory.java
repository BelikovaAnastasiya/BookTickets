package epam.bookticket.logic.service.factory;

import epam.bookticket.logic.service.*;
import epam.bookticket.logic.service.impl.*;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private final BenefitService benefitService = new BenefitServiceImpl();
    private final MovieService movieService = new MovieServiceImpl();
    private final ReservationService reservationService = new ReservationServiceImpl();
    private final ReviewService reviewService = new ReviewServiceImpl();
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance()
    {
        return instance;
    }

    public BenefitService getBenefitService() {
        return benefitService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public ReviewService getReviewService() {
        return reviewService;
    }

    public UserService getUserService() {
        return userService;
    }
}
