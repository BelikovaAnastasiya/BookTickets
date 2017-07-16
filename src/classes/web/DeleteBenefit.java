package classes.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBenefit extends HttpServlet {

    public DeleteBenefit()
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
        System.out.println("hello");
    }
}
