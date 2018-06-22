package minisplit.event;

import java.io.PrintStream;

import minisplit.date.Date;
import minisplit.group.ListOfPersons;
import minisplit.group.Person;

public class Event {
    private final PaymentDetails eventPaymentDetails;
    private final EventDetails   eventDetails;

    public Event(Date date, Amount amountPaid, Person participant, EventDescription nameOfEvent) {
        this.eventPaymentDetails = new PaymentDetails(amountPaid, participant);
        this.eventDetails        = new EventDetails(date, nameOfEvent);
    }

    public void addPersonsNotParticipating(Person person) {
        eventPaymentDetails.addPersonsNotParticipating(person);
    }

    Amount amountPaid(Person person) {
        return eventPaymentDetails.amountPaid(person);
    }

    Amount amountToPay(Person person) {
        return eventPaymentDetails.amountToPay(person);
    }

    int deductNotParticipated(ListOfPersons participants) {
        return eventPaymentDetails.deductNotParticipated(participants);
    }

    void printDetails(PrintStream out) {
        eventDetails.printEventDetails(out);
    }
}
