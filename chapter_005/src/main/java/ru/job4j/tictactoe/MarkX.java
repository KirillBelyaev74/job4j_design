package ru.job4j.tictactoe;

/**
 * Класс для пользователя, который ходит Х
 */
public class MarkX implements Mark {

    @Override
    public String ask(Console console) {
        return console.ask("Ваш ход " + getValue() + "! Выберите клетку: ");
    }

    public String getValue() {
        return "X";
    }
}
