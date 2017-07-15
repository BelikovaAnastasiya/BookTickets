package classes.logic.controller.command;

import java.util.List;

public interface Command {
     String execute(String request);
     List executeWithData(String request);
}
