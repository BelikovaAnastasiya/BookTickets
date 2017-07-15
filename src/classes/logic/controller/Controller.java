package classes.logic.controller;

import classes.logic.controller.command.Command;

import java.util.ArrayList;
import java.util.List;

public final class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request)
    {
        String commandName;
        Command executionCommand;

        char paramDelimeter = ' ';
        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = commandProvider.getCommand(commandName);

        String response;
        response = executionCommand.execute(request);
        return response;
    }

    public List executeTaskWithData(String request)
    {
        String commandName;
        Command executionCommand;

        char paramDelimeter = ' ';
        commandName = request.substring(0, request.indexOf(paramDelimeter));
        executionCommand = commandProvider.getCommand(commandName);

        List response = new ArrayList<>();
        response = executionCommand.executeWithData(request);
        return response;
    }
}
