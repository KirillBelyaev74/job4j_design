package ru.job4j.tictactoe;

/**
 * Класс для пользователя, который ходит О
 */
public class MarkO implements Mark {

    @Override
    public String ask(Console console) {
        return console.ask("Ваш ход " + getValue() + "! Выберите клетку: ");
    }

    public String getValue() {
        return "O";
    }
}
