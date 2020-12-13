package ru.job4j.tictactoe;

import java.util.Random;

public class ConsoleBot implements Console {

    private int countCell;

    /**
     * @param countCell - количество клеток
     */
    public ConsoleBot(int countCell) {
        this.countCell = countCell * countCell;
    }

    /**
     * Метод генерирует случайные числа
     * @param ask - сообщение, которое выводиться для пользователя
     * @return - случайно сгенерированое число
     */
    @Override
    public String ask(String ask) {
        System.out.println(ask);
        return String.valueOf(new Random().nextInt(countCell));
    }
}
