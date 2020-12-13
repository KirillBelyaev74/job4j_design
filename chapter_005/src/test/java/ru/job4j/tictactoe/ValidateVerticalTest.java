package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateVerticalTest {

    @Test
    public void whenXWin() {
        String[][] winX = {{"x", "1", "2"}, {"x", "4", "5"}, {"x", "7", "8"}};
        Validate validate = new ValidateVertical();
        assertThat(validate.validate(winX), is("x"));
    }

    @Test
    public void whenXWinTwo() {
        String[][] winX = {{"0", "x", "2"}, {"4", "x", "5"}, {"6", "x", "8"}};
        Validate validate = new ValidateVertical();
        assertThat(validate.validate(winX), is("x"));
    }

    @Test
    public void whenOWin() {
        String[][] winX = {{"0", "1", "o"}, {"3", "4", "o"}, {"6", "7", "o"}};
        Validate validate = new ValidateVertical();
        assertThat(validate.validate(winX), is("o"));
    }

    @Test
    public void whenDontXWin() {
        String[][] winX = {{"0", "1", "2"}, {"4", "x", "5"}, {"6", "x", "8"}};
        Validate validate = new ValidateVertical();
        assertThat(validate.validate(winX), is("-1"));
    }
}
