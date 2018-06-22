package minisplit.group;

import java.io.PrintStream;

public class Name {
    private final String name;

    public Name(String name) {
        this.name = name;
    }

    public void printName(PrintStream out) {
        out.print(name);
    }
}
