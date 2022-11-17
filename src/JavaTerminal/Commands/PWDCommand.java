package JavaTerminal.Commands;

import JavaTerminal.Data;

public class PWDCommand implements ICommand {
    @Override
    public String name() {
        return "pwd";
    }

    @Override
    public String description() {
        return "Shows your current working directory.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        System.out.println(data.dir);
    }
}
