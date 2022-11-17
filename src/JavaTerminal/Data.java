package JavaTerminal;

import java.util.ArrayList;

public class Data {
    /**
     * The current directory that we're in.
     */
    public String dir;

    /**
     * The current user.
     */
    public String user;

    /**
     * The current machine.
     */
    public String machine;

    /**
     * A list of commands which have been ran.
     */
    public ArrayList<String> history = new ArrayList<>();

    /**
     * Has the program exited?
     */
    public boolean quit = false;

    public Data(String dir, String user, String machine) {
        this.dir = dir;
        this.user = user;
        this.machine = machine;
    }
}
