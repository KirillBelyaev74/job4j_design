package ru.job4j.tictactoe;

import java.util.List;

public class ValidateWin {

    private final List<Validate> validates;

    public ValidateWin(List<Validate> validates) {
        this.validates = validates;
    }

    /**
     * Метод проверяет, кто из пользователей выиграл пробегаясь по все классам Validate
     * @param field - поле
     * @return
     */
    public boolean validate(String[][] field) {
        boolean result = false;
        for (Validate validate : this.validates) {
            String win = validate.validate(field);
            if (win.equalsIgnoreCase("x")) {
                System.out.println("Выиграли " + win);
                result = true;
                break;
            } else if (win.equalsIgnoreCase("o")) {
                System.out.println("Выиграли " + win);
                result = true;
                break;
            }
        }
        return result;
    }
}
