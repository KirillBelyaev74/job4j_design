package ru.job4j.parking;

import java.util.Map;

public interface Parking {

    /**
     * Добавление транспорта на парковку
     * @param transport - транспорт который заезжает на парковку
     */
    boolean add(Transport transport);

    /**
     * Распределение мест на парковке
     */
    void distribution();

    /**
     * @param transport - место которое освобождается
     * @return - транспорт, который уезжает
     */
    Transport delete(Transport transport);

    /**
     * Возвращает все паковочные места для легковых машин
     * @return - парковочные места для легковых машин
     */
    int getVolumeCar();

    /**
     * Возвращает все парковочные места для грузовых машин
     * @return - парковочные места для грущовых машин
     */
    int getVolumeTruck();

    /**
     * Генерирует случайное число(имитирует выбранное парковочное место вадителем)
     * @return - возврощает случайное число(выбраное место вадителем)
     */
    int getRandomInt(int numberPlace);
}
