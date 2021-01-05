package ru.job4j.parking;

/**
 * Дачерний класс Car, наследуемый класс Transport
 */
public class Car extends Transport {

    public Car(String name, String numberTransport) {
        super(name, numberTransport, 1);
    }
}
