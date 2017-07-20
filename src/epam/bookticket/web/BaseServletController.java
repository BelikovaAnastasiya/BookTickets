package epam.bookticket.web;

import epam.bookticket.web.controller.BaseController;
import epam.bookticket.web.controller.ControllerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServletController extends HttpServlet {

    private ControllerFactory factory;

    public BaseServletController () {
        super();
        factory = new ControllerFactory();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String controllerName = req.getParameter("controllerName");
            BaseController baseController = factory.create(controllerName);
            baseController.execute(req,resp,req.getServletContext());

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
