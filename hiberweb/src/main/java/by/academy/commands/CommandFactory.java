package by.academy.commands;


public class CommandFactory {

    private CommandFactory() {
    }

    public static ICommands getCommand(String command) {
        return ActionType.valueOf(command).getCommand();
    }
}
