package ru.job4j.parking;

public interface Parking {

    /**
     * Добавление транспорта на парковку
     * @param transport - транспорт который заезжает на парковку
     */
    boolean add(Transport transport);

    /**
     * @param transport - место которое освобождается
     * @return - транспорт, который уезжает
     */
    Transport delete(Transport transport);

    /**
     * Возвращает все паковочные места для транспорта
     * @return - парковочные места для легковых машин
     */
    int getVolumeTransport();
}
