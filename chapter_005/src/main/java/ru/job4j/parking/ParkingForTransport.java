package ru.job4j.parking;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Парковка для машин
 */
public class ParkingForTransport implements Parking {

    /**
     * totalNumberPlace - общее количество мест
     * transports - парковка<номер места парковки, транспорт>
     */
    private int valueCar;
    private int valueTruck;
    private final Map<Integer, Transport> parkingCar = new HashMap<>(this.valueCar);
    private final Map<Integer, Transport> parkingTruck = new HashMap<>(this.valueTruck);

    public ParkingForTransport(int valueCar, int valueTruck) {
        this.valueCar = valueCar;
        this.valueTruck = valueTruck;
    }
    /**
     * Добавление транспорта на парковку
     * @param transport - транспорт который заезжает на парковку
     */
    public boolean add(Transport transport) {
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
     * Генерирует случайное число(имитирует выбранное парковочное место вадителем)
     * @return - возврощает случайное число(выбраное место вадителем)
     */
    @Override
    public int getRandomInt() {
        return new Random().nextInt(this.totalNumberPlace);
    }
}
