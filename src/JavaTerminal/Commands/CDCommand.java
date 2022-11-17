package JavaTerminal.Commands;

import JavaTerminal.Data;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CDCommand implements ICommand {
    @Override
    public String name() {
        return "cd <directory>";
    }

    @Override
    public String description() {
        return "Changes your current working directory.";
    }

    @Override
    public void run(String[] args, Data data, CommandHandler handler) {
        // Spaces might be part of the path, so we'll join our args.
        String newPath = String.join(" ", args);

        // We'll use Path to resolve our newPath.
        // This takes our current path, resolves it against our new one, normalizes to remove .. and such,
        // and makes it absolute (to remove ~ and such).
        Path resolvedPath = Paths.get(data.dir).resolve(newPath).normalize().toAbsolutePath();

        // Now, we just need to verify that it exists.
        if(Files.isDirectory(resolvedPath)) {
            data.dir = resolvedPath.toString();
        } else {
            System.out.println("Error: The specified directory does not exist!");
        }
    }
}
