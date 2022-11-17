package JavaTerminal.Commands;

import JavaTerminal.Data;

public class HistoryCommand implements ICommand {
    @Override
    public String name() {
        return "history";
    }

    @Override
    public String description() {
        return "Displays a list of the commands which have been ran.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        for (String command : data.history) {
            System.out.println(command);
        }
    }
}
