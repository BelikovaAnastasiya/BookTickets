package epam.bookticket.web.controller.action;

import epam.bookticket.logic.bean.Review;
import epam.bookticket.logic.service.ReviewService;
import epam.bookticket.logic.service.exception.ServiceException;
import epam.bookticket.logic.service.factory.ServiceFactory;
import epam.bookticket.web.controller.BaseController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SaveReview extends BaseController{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("username");

        if (request.getParameter("save") != null) {
            Review review = new Review();
            review.setMovieTitle(request.getParameter("title"));
            review.setLoginUser(name);
            review.setRating(Integer.parseInt(request.getParameter("rating")));
            review.setTextReview(request.getParameter("reviewText"));
            try {
                ServiceFactory serviceFactory = ServiceFactory.getInstance();
                ReviewService reviewService = serviceFactory.getReviewService();
                boolean answer = reviewService.addReview(review);

                if (answer) {
                    request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp").forward(request, response);
                } else {
                    request.setAttribute("error", "Невозможно сохранить отзыв. Проверьте введенную информацию!");
                    request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
                }
            } catch (ServiceException e) {

                request.setAttribute("error", e.getMessage());
                request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/personalPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
