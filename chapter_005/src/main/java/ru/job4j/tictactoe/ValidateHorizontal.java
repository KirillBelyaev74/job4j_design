package ru.job4j.tictactoe;

public class ValidateHorizontal implements Validate {

    /**
     * Метод проверяет по горизонтали кто из пользователей выиграл
     * @param field - поле
     * @return - Х или О
     */
    @Override
    public String validate(String[][] field) {
        String value = null;
        int index = 0;
        for (int x = 0; x != field.length; x++) {
            index = 1;
            value = field[x][0];
            for (int y = 1; y != field.length; y++) {
                if (field[x][y].equalsIgnoreCase(value)) {
                    index++;
                }
            }
            if (index == field.length) {
                break;
            }
        }
        return index == field.length ? value : "-1";
    }
}
