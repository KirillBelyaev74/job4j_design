package ru.job4j.parking;

/**
 * Родительский класс Transport
 */
public class Transport {

    /**
     * name - Название транспорта
     * placeBusy - Количство мест занимаемое транспортом
     */
    private String name;
    private String numberTransport;
    private int placeBusy;

    public Transport(String name, String numberTransport, int placeBusy) {
        this.name = name;
        this.numberTransport = numberTransport;
        this.placeBusy = placeBusy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberTransport() {
        return this.numberTransport;
    }

    public void setNumberTransport(String numberTransport) {
        this.numberTransport = numberTransport;
    }

    public int getPlaceBusy() {
        return placeBusy;
    }

    public void setPlaceBusy(int placeBusy) {
        this.placeBusy = placeBusy;
    }
}
