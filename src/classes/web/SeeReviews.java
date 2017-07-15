package classes.web;

import classes.logic.bean.Review;
import classes.logic.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeeReviews extends HttpServlet {

    public SeeReviews()
    {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        processRequest(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {

        request.setCharacterEncoding("UTF-8");
        Controller controller = new Controller();
        List<Review> reviews = new ArrayList<Review>();
        reviews = controller.executeTaskWithData("see_user_reviews " + request.getSession().getAttribute("username"));
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

    }

}
