package minisplit.date;

import java.io.PrintStream;

class Year {
    private final int year;

    Year(int year) {
        this.year = year;
    }

    void printYear(PrintStream out) {
        out.print(year + ": ");
    }
}
