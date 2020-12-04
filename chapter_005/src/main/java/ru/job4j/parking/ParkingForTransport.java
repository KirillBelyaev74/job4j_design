package ru.job4j.parking;

import java.util.*;

/**
 * Парковка для машин
 */
public class ParkingForTransport implements Parking {

    /**
     * valueCar - общее количество мест для легковых машин
     * valueTruck - общее количество мест для грузавых машин
     * parkingCar - парковка<номер места парковки, легковые машины>
     * parkingTruck - парковка<номер места парковки, грузовые машины>
     */
    private int valueCar;
    private int valueTruck;
    private final Map<Integer, Transport> parkingCar = new HashMap<>(this.valueCar);
    private final Map<Integer, Truck> parkingTruck = new HashMap<>(this.valueTruck);

    public ParkingForTransport(int valueCar, int valueTruck) {
        this.valueCar = valueCar;
        this.valueTruck = valueTruck;
    }
    /**
     * Добавление транспорта на парковку
     * @param transport - транспорт который заезжает на парковку
     */
    public boolean add(Transport transport) {
        return false;
    }

    /**
     * Распределение мест на парковке
     */
    @Override
    public void distribution() {
    }

    /**
     * @param transport - место которое освобождается
     * @return - транспорт, который уезжает
     */
    public Transport delete(Transport transport) {
        return null;
    }

    /**
     * Возвращает все паковочные места для легковых машин
     * @return - парковочные места для легковых машин
     */
    public Map<Integer, Transport> getParkingCar() {
        return this.parkingCar;
    }

    /**
     * Возвращает все парковочные места для грузовых машин
     * @return - парковочные места для грущовых машин
     */
    public Map<Integer, Truck> getParkingTruck() {
        return this.parkingTruck;
    }

    /**
     * Генерирует случайное число(имитирует выбранное парковочное место вадителем)
     * @return - возврощает случайное число(выбраное место вадителем)
     */
    @Override
    public int getRandomInt(int numberPlace) {
        return new Random().nextInt(numberPlace);
    }
}
