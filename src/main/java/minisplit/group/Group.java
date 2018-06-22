package minisplit.group;

import java.io.PrintStream;

import minisplit.event.Event;

public class Group {
    private final GroupDetails groupDetails;
    private final Name         groupName;

    public Group(Name groupName, ListOfPersons participants) {
        this.groupDetails = new GroupDetails(participants);
        this.groupName    = groupName;
    }

    public void addEvent(Event event) {
        groupDetails.addEvent(event);
    }

    public void calculateTransfers(PrintStream out) {
        out.println("Calculation for : ");
        groupName.printName(out);
        groupDetails.calculateTransfers(out);
        groupDetails.clear();
    }
}
