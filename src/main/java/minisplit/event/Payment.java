package minisplit.event;

import minisplit.group.Person;

class Payment {
    private final Person payer;
    private final Amount amount;

    Payment(Amount amount, Person payer) {
        this.payer  = payer;
        this.amount = amount;
    }

    Amount amountPaid(Person person) {
        if (person.equals(payer)) {
            return amount;
        }

        return new Amount();
    }

    Amount amountToPay() {
        return amount;
    }
}
