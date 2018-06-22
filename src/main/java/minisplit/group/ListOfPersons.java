package minisplit.group;

import java.io.PrintStream;

import java.util.ArrayList;

import minisplit.event.Amount;
import minisplit.event.EventList;
import minisplit.event.SummarizeAndCalculate;

public class ListOfPersons {
    private final ArrayList<Person> listOfPersons;

    public ListOfPersons() {
        this.listOfPersons = new ArrayList<>();
    }

    public void addCurrent(ListOfPersons persons, int i) {
        Person tempPerson = persons.listOfPersons.get(i);

        this.listOfPersons.add(tempPerson);
    }

    public void addPerson(Person person) {
        listOfPersons.add(person);
    }

    SummarizeAndCalculate calculateTransfers(PrintStream out, EventList events) {
        SummarizeAndCalculate summarizeAndCalculate = new SummarizeAndCalculate();
        Person                personUsedforCalculationPurposes;
        Amount                amountUsedforCalculationPurposes;

        int i = 0;
        while (i < this.setSize()) {
            personUsedforCalculationPurposes = listOfPersons.get(i);
            amountUsedforCalculationPurposes = personUsedforCalculationPurposes.calculateTransfers(this, events, out);
            summarizeAndCalculate.addAmount(amountUsedforCalculationPurposes);
            i++;
        }

        return summarizeAndCalculate;
    }

    public boolean contains(Person person) {
        return listOfPersons.contains(person);
    }

    public void printNameIndex(PrintStream out, int j) {
        listOfPersons.get(j).printName(out);
    }

    public int setSize() {
        return listOfPersons.size();
    }
}
