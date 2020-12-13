package ru.job4j.tictactoe;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateDiagonalOneTest {

    @Test
    public void whenXWin() {
        String[][] winX = {{"0", "1", "x"}, {"4", "x", "5"}, {"x", "7", "8"}};
        Validate validate = new ValidateDiagonalOne();
        assertThat(validate.validate(winX), is("x"));
    }

    @Test
    public void whenDontXWin() {
        String[][] winX = {{"0", "1", "2"}, {"4", "x", "5"}, {"x", "7", "8"}};
        Validate validate = new ValidateDiagonalOne();
        assertThat(validate.validate(winX), is("-1"));
    }
}
