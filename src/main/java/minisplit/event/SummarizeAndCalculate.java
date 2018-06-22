package minisplit.event;

import java.io.PrintStream;

import java.util.ArrayList;

import minisplit.group.ListOfPersons;

public class SummarizeAndCalculate {
    private final ArrayList<Amount> summarizeAndCalculate;

    public SummarizeAndCalculate() {
        this.summarizeAndCalculate = new ArrayList<>();
    }

    public void addAmount(Amount amount) {
        summarizeAndCalculate.add(amount);
    }

    public void calculateTransfers(ListOfPersons participants, PrintStream out) {
        ListOfPersons         moneyReceivers = new ListOfPersons();
        ListOfPersons         moneyPayers    = new ListOfPersons();
        SummarizeAndCalculate moneyToReceive = new SummarizeAndCalculate();
        SummarizeAndCalculate moneyToPay     = new SummarizeAndCalculate();
        Amount                amountUsedforCalculationPurposes1;

        for (int i = 0; i < summarizeAndCalculate.size(); i++) {
            amountUsedforCalculationPurposes1 = summarizeAndCalculate.get(i);

            if (amountUsedforCalculationPurposes1.biggerZero(new Amount(0))) {
                moneyToReceive.addAmount(amountUsedforCalculationPurposes1);
                moneyReceivers.addCurrent(participants, i);
            }

            if (!amountUsedforCalculationPurposes1.biggerZero(new Amount(0))) {
                moneyToPay.addAmount(amountUsedforCalculationPurposes1);
                moneyPayers.addCurrent(participants, i);
            }
        }

        summarizeListsAndCalculate(moneyPayers, moneyReceivers, moneyToPay, moneyToReceive, out);
    }

    private void summarizeListsAndCalculate(ListOfPersons moneyPayers, ListOfPersons moneyReceivers,
                                            SummarizeAndCalculate moneyToPay, SummarizeAndCalculate moneyToReceive,
                                            PrintStream out) {
        Amount amountUsedforCalculationPurposes1;
        Amount amountUsedforCalculationPurposes2;
        int    counter = 0;

        amountUsedforCalculationPurposes1 = moneyToPay.summarizeAndCalculate.get(0);
        out.println();

        for (int j = 0; j < moneyReceivers.setSize(); j++) {
            amountUsedforCalculationPurposes2 = moneyToReceive.summarizeAndCalculate.get(j);

            while (amountUsedforCalculationPurposes2.notZero()) {
                if (amountUsedforCalculationPurposes2.biggerZero(amountUsedforCalculationPurposes1)) {
                    moneyReceivers.printNameIndex(out, j);
                    out.print(" receives ");
                    amountUsedforCalculationPurposes1.printNegative(out);
                    out.print(" from ");
                    moneyPayers.printNameIndex(out, counter);
                    out.println();
                    amountUsedforCalculationPurposes2.addAmount(amountUsedforCalculationPurposes1);

                    if (counter + 1 < moneyToPay.summarizeAndCalculate.size()) {
                        amountUsedforCalculationPurposes1 = moneyToPay.summarizeAndCalculate.get(++counter);
                    }
                }

                if (!(amountUsedforCalculationPurposes2.biggerZero(amountUsedforCalculationPurposes1))) {
                    moneyReceivers.printNameIndex(out, j);
                    out.print(" receives ");
                    amountUsedforCalculationPurposes2.printPositive(out);
                    out.print(" from ");
                    moneyPayers.printNameIndex(out, counter);
                    out.println();
                    amountUsedforCalculationPurposes1.addAmount(amountUsedforCalculationPurposes2);
                    amountUsedforCalculationPurposes2.reset();
                }
            }
        }
    }
}
