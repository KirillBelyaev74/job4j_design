package ru.job4j.tictactoe;

import java.util.Scanner;

public class ConsoleClient implements Console {

    /**
     * Выводит сообщение пользователю
     * @param ask - сообщение
     * @return - число, которое выбрал пользователь
     */
    @Override
    public String ask(String ask) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(ask);
        return String.valueOf(scanner.nextInt());
    }
}
