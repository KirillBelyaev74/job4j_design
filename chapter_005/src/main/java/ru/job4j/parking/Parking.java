package ru.job4j.parking;

public interface Parking {

    /**
     * Добавление транспорта на парковку
     * @param transport - транспорт который заезжает на парковку
     */
    void add(Transport transport);

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
     * Генерирует случайное число(имитирует выбранное парковочное место вадителем)
     * @return - возврощает случайное число(выбраное место вадителем)
     */
    int getRandomInt();
}
