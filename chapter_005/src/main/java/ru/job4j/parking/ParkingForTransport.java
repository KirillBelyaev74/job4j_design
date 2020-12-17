package ru.job4j.parking;

import java.util.*;

/**
 * Парковка для машин
 */
public class ParkingForTransport implements Parking {

    /**
     * valueTransport - общее количество мест для транспорта
     * parkingTransport - парковка<номер места парковки, транспорт>
     * numberParking - количество занятых мест
     */
    private int valueParking;
    private final Map<Integer, Transport> parkingTransport = new HashMap<>(this.valueParking);
    private int numberParking = 1;

    public ParkingForTransport(int valueTransport) {
        this.valueParking = valueTransport;
    }
    /**
     * Добавление транспорта на парковку
     * @param transport - транспорт который заезжает на парковку
     */
    public boolean add(Transport transport) {
        if(transport == null) {
            throw new NullPointerException();
        }
        if(transport.getPlaceBusyCar() > this.valueParking - this.parkingTransport.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(this.parkingTransport.containsValue(transport)) {
            throw new IllegalArgumentException();
        }
        for(int index = 0; index != transport.getPlaceBusyCar(); index++) {
            this.parkingTransport.put(this.numberParking++, transport);
        }
        return this.parkingTransport.containsValue(transport);
    }

    /**
     * @param transport - место которое освобождается
     * @return - транспорт, который уезжает
     */
    public Transport delete(Transport transport) {
        if(!this.parkingTransport.containsValue(transport)) {
            throw new IllegalArgumentException();
        }
        for(int index = 1; index != this.numberParking; index++) {
            Transport transportParking = this.parkingTransport.get(index);
            if (transportParking != null &&
                    transportParking.getNumberTransport().equalsIgnoreCase(transport.getNumberTransport())) {
                this.parkingTransport.remove(index);
            }
        }
        return transport;
    }

    /**
     * Возвращает количество занятых паковочных мест для транспорта
     * @return - парковочные места для легковых машин
     */
    public int getVolumeTransport() {
        return this.parkingTransport.size();
    }
}
