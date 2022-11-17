package JavaTerminal.Commands;

import JavaTerminal.Data;

import java.util.ArrayList;

public class CommandHandler {
    public ArrayList<ICommand> commands = new ArrayList<>();

    public void register(ICommand handler) {
        commands.add(handler);
    }

    public void handle(String cmd, String[] args, Data data) {
        // We'll show an error message if there's no command.
        String cmdName = cmd.trim().toLowerCase();

        for (ICommand command : commands) {
            // The command name includes args, so we'll only get the command part.
            if(command.name().split(" ")[0].trim().toLowerCase().equals(cmdName)) {
                // We found the command.
                command.run(args, data, this);
                return;
            }
        }

        // No command was found.
        System.out.println("Error: No such command exists. Type help to see a list of available commands.");
    }
}
