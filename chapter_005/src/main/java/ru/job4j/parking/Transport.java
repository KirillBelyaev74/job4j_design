package ru.job4j.parking;

/**
 * Родительский класс Transport
 */
public class Transport {

    /**
     * name - Название транспорта
     * numberTransport - номер машины
     * placeBusyCar - количество мест занимемым места на парковке для легковых машин
     */
    private String name;
    private String numberTransport;
    private int placeBusyCar;

    public Transport(String name, String numberTransport, int placeBusy) {
        this.name = name;
        this.numberTransport = numberTransport;
        this.placeBusyCar = placeBusy;
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

    public int getPlaceBusyCar() {
        return placeBusyCar;
    }

    public void setPlaceBusyCar(int placeBusyCar) {
        this.placeBusyCar = placeBusyCar;
    }
}
