package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateHorizontalTest {

    @Test
    public void whenXWin() {
        String[][] winX = {{"X", "X", "X"}, {"3", "4", "5"}, {"6", "7", "8"}};
        Validate validate = new ValidateHorizontal();
        assertThat(validate.validate(winX), is("X"));
    }

    @Test
    public void whenDontXWin() {
        String[][] winX = {{"0", "1", "2"}, {"x", "x", "5"}, {"6", "7", "8"}};
        Validate validate = new ValidateHorizontal();
        assertThat(validate.validate(winX), is("-1"));
    }

    @Test
    public void whenOWin() {
        String[][] winX = {{"0", "1", "2"}, {"x", "x", "5"}, {"o", "o", "o"}};
        Validate validate = new ValidateHorizontal();
        assertThat(validate.validate(winX), is("o"));
    }
}
