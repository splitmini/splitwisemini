package minisplit.date;

import java.io.PrintStream;

public class Date {
    private final MonthDay monthDay;
    private final Year     year;

    public Date(int day, int month, int year) {
        this.monthDay = new MonthDay(new Month(month), new Day(day));
        this.year     = new Year(year);
    }

    public void printDate(PrintStream out) {
        out.print(" at ");
        monthDay.printMonthDay(out);
        year.printYear(out);
    }
}
