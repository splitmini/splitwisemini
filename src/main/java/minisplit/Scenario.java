package minisplit;

import minisplit.date.Date;
import minisplit.event.Amount;
import minisplit.event.Event;
import minisplit.event.EventDescription;
import minisplit.group.Group;
import minisplit.group.ListOfPersons;
import minisplit.group.Name;
import minisplit.group.Person;

class Scenario {
    public static void main(String[] args) {
        Person markus    = new Person("Markus");
        Person        christoph = new Person("Christoph");
        Person        thomas    = new Person("Thomas");
        ListOfPersons residents = new ListOfPersons();

        residents.addPerson(markus);
        residents.addPerson(christoph);
        residents.addPerson(thomas);

        Group WG                   = new Group(new Name("WG"), residents);
        Amount           christophRent        = new Amount((float) 1275.80);
        Amount           wgThomasBeer         = new Amount((float) 63.80);
        Amount           internetCostMarkus   = new Amount((float) 29.99);
        Amount           thomasFridgeWG       = new Amount((float) 104.88);
        Date             christophRentMarch   = new Date(31, 3, 2017);
        Date             christophRentApril   = new Date(31, 4, 2017);
        Date             dateBeer             = new Date(1, 7, 2017);
        Date             internetDateMarch    = new Date(31, 3, 2017);
        Date             internetDateApril    = new Date(31, 4, 2017);
        Date             fridgeDate           = new Date(1, 7, 2017);
        EventDescription rentName             = new EventDescription("Pay rent");
        EventDescription beerName             = new EventDescription("Pay beer");
        EventDescription internetName         = new EventDescription("Pay internet");
        EventDescription fridgeName           = new EventDescription("fill the fridge");
        Event            rentPayMarch         = new Event(christophRentMarch, christophRent, christoph, rentName);
        Event            rentPayApril         = new Event(christophRentApril, christophRent, christoph, rentName);
        Event            beerPaymentWG        = new Event(dateBeer, wgThomasBeer, thomas, beerName);
        Event            fridgePayment        = new Event(fridgeDate, thomasFridgeWG, thomas, fridgeName);
        Event            internetPaymentMarch = new Event(internetDateMarch, internetCostMarkus, markus, internetName);
        Event            internetPaymentApril = new Event(internetDateApril, internetCostMarkus, markus, internetName);

        beerPaymentWG.addPersonsNotParticipating(markus);
        WG.addEvent(rentPayMarch);
        WG.addEvent(internetPaymentMarch);
        WG.addEvent(beerPaymentWG);
        WG.addEvent(fridgePayment);

        Person        jessica              = new Person("Jessica");
        Person        sina                 = new Person("Sina");
        Person        jens                 = new Person("Jens");
        Person        gerd                 = new Person("Gerd");
        Person        kathrin              = new Person("Kathrin");
        Person        simon                = new Person("Simon");
        ListOfPersons cityTripParticipants = new ListOfPersons();

        cityTripParticipants.addPerson(jessica);
        cityTripParticipants.addPerson(sina);
        cityTripParticipants.addPerson(jens);
        cityTripParticipants.addPerson(gerd);
        cityTripParticipants.addPerson(kathrin);
        cityTripParticipants.addPerson(thomas);
        cityTripParticipants.addPerson(christoph);
        cityTripParticipants.addPerson(simon);

        Group            cityTrip               = new Group(new Name("Citytrip"), cityTripParticipants);
        Amount           jensCityTour           = new Amount((float) 148);
        Amount           musicalSina            = new Amount((float) 500);
        Amount           amountKathrinMusical   = new Amount((float) 384.50);
        Amount           cityTripThomasBeer     = new Amount((float) 66);
        Date             dateJensCityTour       = new Date(30, 10, 2017);
        Date             dateMusical            = new Date(30, 10, 2017);
        Date             cityTripThomasBeerDate = new Date(30, 10, 2017);
        EventDescription jensCityTourName       = new EventDescription("Pay for city tour");
        EventDescription musicalName            = new EventDescription("pay for Musical");
        Event            jensCityTourEvent      = new Event(dateJensCityTour, jensCityTour, jens, jensCityTourName);
        Event            paymentMusicalSina     = new Event(dateMusical, musicalSina, sina, musicalName);
        Event            paymentMusicalKathrin  = new Event(dateMusical, amountKathrinMusical, kathrin, musicalName);
        Event            cityTripBeerThomasName = new Event(cityTripThomasBeerDate,
                                                            cityTripThomasBeer,
                                                            thomas,
                                                            beerName);

        paymentMusicalSina.addPersonsNotParticipating(simon);
        paymentMusicalSina.addPersonsNotParticipating(thomas);
        paymentMusicalSina.addPersonsNotParticipating(jens);
        paymentMusicalKathrin.addPersonsNotParticipating(simon);
        paymentMusicalKathrin.addPersonsNotParticipating(thomas);
        paymentMusicalKathrin.addPersonsNotParticipating(jens);
        cityTripBeerThomasName.addPersonsNotParticipating(simon);
        cityTrip.addEvent(jensCityTourEvent);
        cityTrip.addEvent(paymentMusicalSina);
        cityTrip.addEvent(paymentMusicalKathrin);
        cityTrip.addEvent(cityTripBeerThomasName);
        cityTrip.calculateTransfers(System.out);
        WG.calculateTransfers(System.out);
        WG.addEvent(rentPayApril);
        WG.addEvent(internetPaymentApril);
        WG.calculateTransfers(System.out);
    }
}
