package minisplit.date;

import java.io.PrintStream;

class Day {
    private final int day;

    Day(int day) {
        this.day = day;
    }

    void printDay(PrintStream out) {
        out.print(day + ".");
    }
}
