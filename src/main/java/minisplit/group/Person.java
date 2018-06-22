package minisplit.group;

import java.io.PrintStream;

import minisplit.event.Amount;
import minisplit.event.EventList;

public class Person {
    private final Name name;

    public Person(String name) {
        this.name = new Name(name);
    }

    Amount calculateTransfers(ListOfPersons listOfPersons, EventList events, PrintStream out) {
        out.println();
        name.printName(out);
        out.println(" has paid :");

        Amount paid = events.amountPaid(this, out);

        out.println();
        out.println(" has to pay: ");

        Amount toPay = events.amountToPay(listOfPersons, this, out);

        paid.deduct(toPay);

        return paid;
    }

    void printName(PrintStream out) {
        name.printName(out);
    }
}
