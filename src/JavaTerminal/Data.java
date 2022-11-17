package JavaTerminal;

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
     * Has the program exited?
     */
    public boolean quit = false;

    public Data(String dir, String user, String machine) {
        this.dir = dir;
        this.user = user;
        this.machine = machine;
    }
}
