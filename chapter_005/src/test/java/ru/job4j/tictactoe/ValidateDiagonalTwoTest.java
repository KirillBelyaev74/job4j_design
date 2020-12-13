package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateDiagonalTwoTest {

    @Test
    public void whenXWin() {
        String[][] winX = {{"x", "1", "2"}, {"3", "x", "5"}, {"6", "7", "x"}};
        Validate validate = new ValidateDiagonalTwo();
        assertThat(validate.validate(winX), is("x"));
    }

    @Test
    public void whenDontXWin() {
        String[][] winX = {{"x", "1", "2"}, {"3", "x", "5"}, {"6", "7", "8"}};
        Validate validate = new ValidateDiagonalTwo();
        assertThat(validate.validate(winX), is("-1"));
    }
}
