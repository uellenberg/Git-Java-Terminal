package JavaTerminal.Commands;

import JavaTerminal.Data;

import java.util.Optional;

public class HelpCommand implements ICommand {

    @Override
    public String name() {
        return "help [command]";
    }

    @Override
    public String description() {
        return "Shows a list of available commands.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        // If we have an argument, we'll look up info for a specific command.
        if(args.length > 0) {
            Optional<ICommand> command = handler.commands.stream().filter(cmd -> cmd.name().split(" ")[0].trim().equalsIgnoreCase(args[0].trim())).findFirst();
            if(command.isPresent()) {
                ICommand actualCommand = command.get();
                System.out.println(actualCommand.name() + " - " + actualCommand.description());
            } else {
                System.out.println("This command does not exist!");
            }
        } else {
            // Otherwise, we'll show every command.
            for (ICommand command : handler.commands) {
                System.out.println(command.name() + " - " + command.description());
            }
        }
    }
}