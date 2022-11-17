package JavaTerminal;

import JavaTerminal.Commands.CDCommand;
import JavaTerminal.Commands.CommandHandler;
import JavaTerminal.Commands.HelpCommand;
import JavaTerminal.Commands.LSCommmand;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = new Data(System.getProperty("user.dir"), "java", "git-activity");
        CommandHandler handler = new CommandHandler();

        // Register our commands.
        handler.register(new HelpCommand());
        handler.register(new CDCommand());
        handler.register(new LSCommmand());

        // Keep accepting commands while our scanning is running, and
        // we haven't quit.
        printPrompt(data);
        while(scanner.hasNextLine() && !data.quit) {
            String line = scanner.nextLine();
            if(line.isBlank()) continue;

            // The first word is going to be the command.
            // The rest will be the arguments to it.
            // We'll split it up into a command String and an
            // array of arguments.
            String[] split = line.split(" ");

            String cmd = split[0];
            String[] cmdArgs = Arrays.stream(split).skip(1).toArray(String[]::new);

            handler.handle(cmd, cmdArgs, data);

            printPrompt(data);
        }
    }

    private static void printPrompt(Data data) {
        System.out.print(data.user + "@" + data.machine + ":" + data.dir + "> ");
    }
}