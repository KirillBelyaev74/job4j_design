package ru.job4j.parking;

/**
 * Дачерний класс Car, наследуемый класс Transport
 */
public class Car extends Transport{

    public Car(String name, String numberTransport, int placeBusy) {
        super(name, numberTransport, placeBusy);
    }

    /**
     * Возвращает занимаемое место машиной
     * @return - возвращает всегда 1, потому что
     */
    @Override
    public int getPlaceBusy() {
        return 1;
    }
}
