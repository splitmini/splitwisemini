package minisplit.event;

import java.io.PrintStream;

public class Amount {
    private float amount;

    Amount() {
        this.amount = 0;
    }

    Amount(Amount amount) {
        this.amount = amount.amount;
    }

    public Amount(float initialAmount) {
        this.amount = initialAmount;
    }

    void addAmount(Amount amount) {
        this.amount += amount.amount;
    }

    boolean biggerZero(Amount amountUsedforCalculationPurposes) {
        return (this.amount > (-amountUsedforCalculationPurposes.amount));
    }

    public void deduct(Amount amount) {
        this.amount -= amount.amount;
    }

    void divide(Amount amount) {
        this.amount /= amount.amount;
    }

    boolean notZero() {
        return (!(amount == ((float) 0)));
    }

    void printNegative(PrintStream out) {
        out.print(-amount);
    }

    void printPositive(PrintStream out) {
        out.print(amount);
    }

    void reset() {
        this.amount = 0;
    }
}
