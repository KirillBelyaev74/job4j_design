package ru.job4j.tictactoe;

public class ValidateVertical implements Validate {

    /**
     * Метод проверяет по вертикали кто из пользователей выиграл
     * @param field - поле
     * @return - Х или О
     */
    @Override
    public String validate(String[][] field) {
        String value = null;
        int index = 0;
        for (int x = 0; x != field.length; x++) {
            index = 1;
            value = field[0][x];
            for (int y = 1; y != field.length; y++) {
                if (field[y][x].equalsIgnoreCase(value)) {
                    index++;
                }
            }
            if(index == field.length) {
                break;
            }
        }
        return index == field.length ? value : "-1";
    }
}
