package ru.job4j.parking;

/**
 * Дачерний класс Truck, наследуемый класс Transport
 */
public class Truck extends Transport{

    public Truck(String name, String numberTransport, int placeBusy) {
        super(name, numberTransport, placeBusy);
    }
}
