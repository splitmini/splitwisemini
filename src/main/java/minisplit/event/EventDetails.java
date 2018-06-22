package minisplit.event;

import java.io.PrintStream;

import minisplit.date.Date;

class EventDetails {
    private final EventDescription nameOfEvent;
    private final Date date;

    EventDetails(Date date, EventDescription nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
        this.date        = date;
    }

    void printEventDetails(PrintStream out) {
        nameOfEvent.printName(out);
        date.printDate(out);
    }
}
