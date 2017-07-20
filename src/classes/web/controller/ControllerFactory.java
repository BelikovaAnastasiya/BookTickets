package classes.web.controller;

import classes.web.controller.action.*;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, Class<?>> map;

    public ControllerFactory() {
        map = defaultMap();
    }

    public BaseController create (String controllerName) {
        Class ControllerClass = (Class) map.get(controllerName);
        if (ControllerClass == null)
            throw new RuntimeException(getClass() + " was unable to find an controller named '" + controllerName + "'.");
        BaseController controllerInstance = null;
        try {
            controllerInstance = (BaseController) ControllerClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return controllerInstance;
    }

    public Map<String, Class<?>> defaultMap() {
        Map<String, Class<?>> map = new HashMap<String, Class<?>>();
        map.put("AddBenefit", AddBenefit.class);
        map.put("AddMovie", AddMovie.class);
        map.put("AddReview", AddReview.class);
        map.put("AddUser", AddUser.class);
        map.put("AdminAddUser", AdminAddUser.class);
        map.put("AllMovies", AllMovies.class);
        map.put("BenefitSystem", BenefitSystem.class);
        map.put("CheckUser", CheckUser.class);
        map.put("DeleteBenefit", DeleteBenefit.class);
        map.put("FindFilm", FindFilm.class);
        map.put("MyProfile", MyProfile.class);
        map.put("Registration", Registration.class);
        map.put("SaveNewBenefit", SaveNewBenefit.class);
        map.put("SeeAllUsers", SeeAllUsers.class);
        map.put("SeeBooking", SeeBooking.class);
        map.put("SeeReviews", SeeReviews.class);
        map.put("BookTicket", BookTicket.class);

        ////
        return map;
    }


}