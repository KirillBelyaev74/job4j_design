package ru.job4j.parking;

import java.util.*;

/**
 * Парковка для машин
 */
public class ParkingForTransport implements Parking {

    /**
     * valueParkingCar - общее количество мест для легковых машин
     * valueParkingTruck - общее количество мест для грузовых машин
     * parkingCar - парковка для легковых машин
     * parkingTruck - парковка для грузовых машин
     */
    private int valueParkingCar;
    private int valueParkingTruck;
    private final List<Transport> parkingCar = new ArrayList<>(this.valueParkingCar);
    private final List<Transport> parkingTruck = new ArrayList<>(this.valueParkingTruck);

    public ParkingForTransport(int valueParkingCar, int valueParkingTruck) {
        this.valueParkingCar = valueParkingCar;
        this.valueParkingTruck = valueParkingTruck;
    }
    /**
     * Добавление транспорта на парковку
     * @param transport - транспорт который заезжает на парковку
     */
    public boolean add(Transport transport) {
        this.validate(transport);
        boolean result = false;
        int placeBusyTransport = transport.getPlaceBusyTransport();
        if(placeBusyTransport > 1
                && this.valueParkingTruck == this.parkingTruck.size()
                && placeBusyTransport <= this.valueParkingCar - this.parkingCar.size()) {
            for(int index = 0; index != placeBusyTransport; index++) {
                this.parkingCar.add(transport);
            }
            result = true;
        } else if (placeBusyTransport > 1) {
            this.parkingTruck.add(transport);
            result = true;
        } else {
            this.parkingCar.add(transport);
            result = true;
        }
        return result;
    }

    public void validate(Transport transport) {
        if (transport == null) {
            throw new NullPointerException();
        }
        if (this.parkingCar.contains(transport)) {
            throw new IllegalArgumentException();
        }
        if (this.valueParkingCar == this.parkingCar.size()
                && this.valueParkingTruck == this.parkingTruck.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * @param transport - место которое освобождается
     * @return - транспорт, который уезжает
     */
    public Transport delete(Transport transport) {
        if(!this.parkingCar.contains(transport) && !this.parkingTruck.contains(transport)) {
            throw new IllegalArgumentException();
        }
        int placeBusyTransport = transport.getPlaceBusyTransport();
        if (placeBusyTransport > 1 && this.parkingCar.contains(transport)) {
            for (int index = 0; index != placeBusyTransport; index++) {
                this.parkingCar.remove(transport);
            }
        } else if (placeBusyTransport > 1) {
            this.parkingTruck.remove(transport);
        } else {
            this.parkingCar.remove(transport);
        }
        return transport;
    }

    /**
     * Возвращает количество занятых паковочных мест для легковых машин
     * @return - парковочные места для легковых машин
     */
    public int getVolumeCar() {
        return this.parkingCar.size();
    }

    /**
     * Возвращает количество занятых паковочных мест для грузовых машин
     * @return - парковочные места для легковых машин
     */
    public int getVolumeTruck() {
        return this.parkingTruck.size();
    }
}
