package minisplit.date;

import java.io.PrintStream;

class Month {
    private final int month;

    Month(int month) {
        this.month = month;
    }

    void printMonth(PrintStream out) {
        out.print(month + ".");
    }
}
