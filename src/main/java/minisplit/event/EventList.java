package minisplit.event;

import java.io.PrintStream;

import java.util.ArrayList;

import minisplit.group.ListOfPersons;
import minisplit.group.Person;

public class EventList {
    private final ArrayList<Event> events;

    public EventList() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Amount amountPaid(Person person, PrintStream out) {
        Amount amountUsedforCalculationPurposes;
        Amount amountPaid = new Amount();

        for (Event eventUsedForCalculationPurposes : events) {
            amountUsedforCalculationPurposes = eventUsedForCalculationPurposes.amountPaid(person);

            if (amountUsedforCalculationPurposes.notZero()) {
                amountPaid.addAmount(amountUsedforCalculationPurposes);
                eventUsedForCalculationPurposes.printDetails(out);
                amountUsedforCalculationPurposes.printPositive(out);
                out.println();
            }
        }

        return amountPaid;
    }

    public Amount amountToPay(ListOfPersons participants, Person person, PrintStream out) {
        Amount amountUsedforCalculationPurposes;
        Amount amountToPay = new Amount();

        for (Event eventUsedForCalculationPurposes : events) {
            amountUsedforCalculationPurposes = new Amount(eventUsedForCalculationPurposes.amountToPay(person));

            if (amountUsedforCalculationPurposes.notZero()) {
                eventUsedForCalculationPurposes.printDetails(out);
                amountUsedforCalculationPurposes.divide(
                    new Amount(eventUsedForCalculationPurposes.deductNotParticipated(participants)));
                amountUsedforCalculationPurposes.printPositive(out);
                out.println();
                amountToPay.addAmount(amountUsedforCalculationPurposes);
            }
        }

        return amountToPay;
    }
}
