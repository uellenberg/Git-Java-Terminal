package JavaTerminal.Commands;

import JavaTerminal.Data;

public interface ICommand {
    public String name();
    public String description();

    public void run(String[] args, Data data, CommandHandler handler);
}
