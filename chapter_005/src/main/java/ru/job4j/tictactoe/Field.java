package ru.job4j.tictactoe;

import java.util.List;

public class Field {

    private String[][] field;
    private final List<Validate> validates;
    private final List<Console> consoles;
    private final List<Mark> marks;
    private final ValidateWin validateWin;

    public Field(int countCell, List<Validate> validates, List<Console> consoles, List<Mark> marks, ValidateWin validateWin) {
        this.field = new String[countCell][countCell];
        this.validates = validates;
        this.consoles = consoles;
        this.marks = marks;
        this.validateWin = validateWin;
    }

    /**
     * Метод заполняет клетки числами
     */
    public void fill() {
        int index = 1;
        for (int x = 0; x != this.field.length; x++) {
            for (int y = 0; y != this.field[x].length; y++) {
                this.field[x][y] = String.valueOf(index++);
            }
        }
    }

    /**
     * Метод выводит в консоль все поле
     */
    public void print() {
        for (int x = 0; x != this.field.length; x++) {
            for (int y = 0; y != this.field[x].length; y++) {
                System.out.print(this.field[x][y] + " ");
            }
            System.out.print(System.lineSeparator());
        }
    }

    /**
     * Метод проверяет наличие клетки
     * @param cell - клетка, выбранная пользователем, которую нужно проверить
     * @param value - Х или О
     * @return
     */
    public boolean validateCell(String cell, String value) {
        if (cell == null) {
            throw new NullPointerException();
        }
        boolean result = false;
        for (int x = 0; x != field.length; x++) {
            for (int y = 0; y != field[x].length; y++) {
                if (field[x][y].equalsIgnoreCase(cell)
                        && !cell.equalsIgnoreCase("x")
                        && !cell.equalsIgnoreCase("y")) {
                    this.field[x][y] = value;
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Метод запрашивает у пользователя выбрать следующий шаг
     * @param mark - пользователь Х или О
     * @param console - пользователь или бот
     * @return
     */
    public boolean stepPerson(Mark mark, Console console) {
        boolean result = false;
        while (true) {
            String stepPerson = mark.ask(console);
            if (this.validateCell(stepPerson, mark.getValue())) {
                result = true;
                break;
            } else {
                System.out.println("Вы выбрали неправильное значение! Повторите попытку.");
            }
        }
        return result;
    }

    public void start() {
        boolean result = true;
        this.fill();
        this.print();
        while (result) {
            for (int index = 0; index != this.consoles.size() && index != this.marks.size(); index++) {
                this.stepPerson(this.marks.get(index), this.consoles.get(index));
                this.print();
                if (this.validateWin.validate(this.field)) {
                    result = false;
                    break;
                }
            }
        }
        this.print();
    }

    /**
     * Метод запрашивает размер поля и количество пользователей, которые примут участие
     * @param args
     */
    public static void main(String[] args) {
        Field field;
        Console console = new ConsoleClient();
        List<Validate> validates = List.of(
                new ValidateHorizontal(),
                new ValidateVertical(),
                new ValidateDiagonalOne(),
                new ValidateDiagonalTwo());
        List<Mark> marks = List.of(new MarkX(), new MarkO());
        ValidateWin validateWin = new ValidateWin(validates);

        String countCell = console.ask("Добрый день. Выберите размер поля(N x N): ");

        while (true) {
            String countPerson = console.ask("Сколько пользователей примут участие? 1 или 2?: ");
            if ("1".equalsIgnoreCase(countPerson)) {
                field = new Field(
                        Integer.parseInt(countCell),
                        validates,
                        List.of(console, new ConsoleBot(Integer.parseInt(countCell))),
                        marks,
                        validateWin);
                break;
            } else if ("2".equalsIgnoreCase(countPerson)) {
                field = new Field(
                        Integer.parseInt(countCell),
                        validates,
                        List.of(console, new ConsoleClient()),
                        marks,
                        validateWin);
                break;
            } else {
                System.out.println("Выберите количество пользователей из предложенных вариантов!");
            }
        }
        field.start();
    }
}