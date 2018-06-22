package minisplit.event;

import minisplit.group.ListOfPersons;
import minisplit.group.Person;

class PaymentDetails {
    private final Payment       payment;
    private final ListOfPersons notParticipated;

    PaymentDetails(Amount AmountPaid, Person payer) {
        this.notParticipated = new ListOfPersons();
        this.payment         = new Payment(AmountPaid, payer);
    }

    void addPersonsNotParticipating(Person person) {
        notParticipated.addPerson(person);
    }

    Amount amountPaid(Person person) {
        return payment.amountPaid(person);
    }

    Amount amountToPay(Person person) {
        if (!notParticipated.contains(person)) {
            return payment.amountToPay();
        }

        return new Amount();
    }

    int deductNotParticipated(ListOfPersons group) {
        return (group.setSize() - notParticipated.setSize());
    }
}
