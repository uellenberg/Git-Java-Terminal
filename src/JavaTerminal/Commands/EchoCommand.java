package JavaTerminal.Commands;

import JavaTerminal.Data;

public class EchoCommand implements ICommand {
    @Override
    public String name() {
        return "echo <text>";
    }

    @Override
    public String description() {
        return "Prints some text to the console.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        // We need to put the input text back together, then print it.
        System.out.println(String.join(" ", args));
    }
}
