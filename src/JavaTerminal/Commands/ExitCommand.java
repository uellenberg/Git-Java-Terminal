package JavaTerminal.Commands;

import JavaTerminal.Data;

public class ExitCommand implements ICommand {
    @Override
    public String name() {
        return "exit";
    }

    @Override
    public String description() {
        return "Exits the terminal.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        data.quit = true;
    }
}
