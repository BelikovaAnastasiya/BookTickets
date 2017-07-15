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

public class AllMovies extends HttpServlet {

    public AllMovies(){}

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
        List<Movie> movies = new ArrayList<Movie>();
        movies = controller.executeTaskWithData("see_movies ");

        if (movies.isEmpty())
        {
            String message = "No movies";
            request.setAttribute("error", message);
            request.getRequestDispatcher("/errorUser.jsp").forward(request,response);
        }
        else
        {
            for(int i=0; i<movies.size(); i++) {
                request.setAttribute("title", movies.get(i).getTitle());
                request.setAttribute("yearOfProduction", movies.get(i).getYearOfProduction());
                request.setAttribute("type", movies.get(i).getType());
                request.setAttribute("mainActors", movies.get(i).getMainActors());
                request.setAttribute("m", movies);
            }
            request.getRequestDispatcher("/allMoviesUser.jsp").forward(request, response);
        }

    }
}
