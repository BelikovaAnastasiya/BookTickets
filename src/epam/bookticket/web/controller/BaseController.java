package epam.bookticket.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseController {

    static private HttpServletResponse resp;
    static private HttpServletRequest req;
    static private ServletContext cont;

    public BaseController () {
        resp = null;
        req = null;
        cont = null;
    }

    public void execute(HttpServletRequest request,  HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

}
