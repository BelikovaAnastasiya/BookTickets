package classes.logic.controller;

import classes.logic.controller.command.Command;
import classes.logic.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<String,Command> repository = new HashMap<>();

    public CommandProvider()
    {
        repository.put("SIGN_IN", new SignIn());
        repository.put("REGISTRATION", new RegistrationUser());
        repository.put("FIND_FILM", new FindMovie());
        repository.put("SEE_MOVIES", new SeeMovies());
        repository.put("SEE_USER_REVIEWS", new UserReviews());
        repository.put("MY_PROFILE", new UserProfile());
        repository.put("SEE_USER_RESERVATIONS", new UserReservation());
        repository.put("ADD_MOVIE", new AddMovie());
        repository.put("SEE_USERS", new SeeUsers());
        repository.put("SEE_ALL_BENEFIT", new SeeAllBenefit());
        ////
    }

    public Command getCommand(String name)
    {
        String commandName = null;
        Command command = null;

        commandName = name.toUpperCase();
        command = repository.get(commandName);
        return command;
    }

}

