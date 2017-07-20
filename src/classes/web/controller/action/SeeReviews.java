package classes.web.controller.action;

import classes.logic.bean.Review;
import classes.logic.service.ReviewService;
import classes.logic.service.exception.ServiceException;
import classes.logic.service.factory.ServiceFactory;
import classes.web.controller.BaseController;

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
        request.setCharacterEncoding("UTF-8");
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
                String message = "No reviews for that user!";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/errorUser.jsp").forward(request,response);
            }
            else {

                request.setAttribute("r", reviews);
                request.getRequestDispatcher("/userReviews.jsp").forward(request, response);
            }
        }catch (ServiceException e)
        {
            e.printStackTrace();
        }
    }
}
