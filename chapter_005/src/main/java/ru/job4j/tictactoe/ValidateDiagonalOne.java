package ru.job4j.tictactoe;

public class ValidateDiagonalOne implements Validate {

    /**
     * Метод проверяет по деагонали кто из пользователей выиграл
     * @param field - поле
     * @return - Х или О
     */
    @Override
    public String validate(String[][] field) {
        String value = field[field.length - 1][0];
        int index = 1;
        for (int x = 1; x != field.length; x++) {
            if (field[field.length - x - 1][x].equalsIgnoreCase(value)) {
                index++;
            }
            if(index == field.length) {
                break;
            }
        }
        return index == field.length ? value : "-1";
    }
}
