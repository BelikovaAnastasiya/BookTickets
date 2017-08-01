package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Review;
import epam.bookticket.logic.service.ReviewService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeeReviews extends BaseController {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        List<Review> reviews = new ArrayList<Review>();
        try
        {
            String login = (String)request.getSession().getAttribute("username");
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ReviewService reviewService = serviceFactory.getReviewService();
            reviews = reviewService.takeUserReviews(login);
            request.setAttribute("user", "My reviews");

            if (reviews.isEmpty())
            {
                String message = "Вы не оставляли отзывы на фильмы!";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/WEB-INF/jsp/errorUser.jsp").forward(request,response);
            }
            else {

                request.setAttribute("r", reviews);
                request.getRequestDispatcher("/WEB-INF/jsp/userReviews.jsp").forward(request, response);
            }
        }catch (ServiceException e)
        {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request,response);
        }
    }
}
