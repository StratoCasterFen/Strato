package by.academy.command;


public class CommandFactory {

    private CommandFactory() {
    }

    public static ICommand getCommand(String command) {
        return ActionType.valueOf(command).getCommand();
    }
}
