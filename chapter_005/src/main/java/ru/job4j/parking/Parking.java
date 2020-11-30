package ru.job4j.parking;

public interface Parking {

    /**
     * Распределение мест на парковке
     * @param transport - транспорт заезжающий на парковку
     */
    void distribution(Transport transport);

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
