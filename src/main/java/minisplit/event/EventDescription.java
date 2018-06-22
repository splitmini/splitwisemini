package minisplit.event;

import java.io.PrintStream;

public class EventDescription {
    private final String name;

    public EventDescription(String name) {
        this.name = name;
    }

    void printName(PrintStream out) {
        out.print(name);
    }
}
