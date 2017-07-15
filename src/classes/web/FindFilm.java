package classes.web;

import classes.logic.bean.Movie;
import classes.logic.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindFilm extends HttpServlet {

    public FindFilm()
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
    {
            request.setCharacterEncoding("UTF-8");
            Controller controller = new Controller();
            String toSend = "find_film " + request.getParameter("search");
            List<Movie> movies = new ArrayList<Movie>();
            movies = controller.executeTaskWithData(toSend);

            if (movies.isEmpty())
            {
                String message = "No movies with that title";
                request.setAttribute("error", message);
                request.getRequestDispatcher("/error.jsp").forward(request,response);
            }
            else
            {
                    request.setAttribute("m", movies);
                    request.getRequestDispatcher("/searchMovieMainPage.jsp").forward(request, response);
            }

    }
}
