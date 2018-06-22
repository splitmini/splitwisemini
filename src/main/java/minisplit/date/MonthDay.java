package minisplit.date;

import java.io.PrintStream;

class MonthDay {
    private final Month month;
    private final Day   day;

    MonthDay(Month month, Day day) {
        this.month = month;
        this.day   = day;
    }

    void printMonthDay(PrintStream out) {
        day.printDay(out);
        month.printMonth(out);
    }
}
