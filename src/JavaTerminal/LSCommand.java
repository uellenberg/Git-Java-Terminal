package JavaTerminal.Commands;

import JavaTerminal.Data;

import java.io.File;

public class LSCommmand implements ICommand {
    @Override
    public String name() {
        return "ls";
    }

    @Override
    public String description() {
        return "Shows every file and folder in your current working directory.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        // We need to get a list of files/folders, then display them.
        File[] files = new File(data.dir).listFiles();

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}