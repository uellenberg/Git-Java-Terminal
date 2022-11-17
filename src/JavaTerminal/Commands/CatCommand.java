package JavaTerminal.Commands;

import JavaTerminal.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CatCommand implements ICommand {
    @Override
    public String name() {
        return "cat <file>";
    }

    @Override
    public String description() {
        return "Prints out the contents of a command.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        // Spaces might be part of the path, so we'll join our args.
        String newPath = String.join(" ", args);

        // We'll use Path to resolve our newPath.
        // This takes our current path, resolves it against our new one, normalizes to remove .. and such,
        // and makes it absolute (to remove ~ and such).
        Path resolvedPath = Paths.get(data.dir).resolve(newPath).normalize().toAbsolutePath();

        if(resolvedPath.toFile().exists()) {
            try {
                System.out.println(Files.readString(resolvedPath));
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file:");
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: This file does not exist.");
        }
    }
}
