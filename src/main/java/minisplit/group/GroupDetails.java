package minisplit.group;

import java.io.PrintStream;

import minisplit.event.Event;
import minisplit.event.EventList;
import minisplit.event.SummarizeAndCalculate;

class GroupDetails {
    private EventList           events;
    private final ListOfPersons groupParticipants;

    GroupDetails(ListOfPersons groupParticipants) {
        this.events            = new EventList();
        this.groupParticipants = groupParticipants;
    }

    void addEvent(Event event) {
        events.addEvent(event);
    }

    void calculateTransfers(PrintStream out) {
        SummarizeAndCalculate summarizeAndCalculate = groupParticipants.calculateTransfers(out, events);

        summarizeAndCalculate.calculateTransfers(groupParticipants, out);
    }

    void clear() {
        this.events = new EventList();
    }
}
