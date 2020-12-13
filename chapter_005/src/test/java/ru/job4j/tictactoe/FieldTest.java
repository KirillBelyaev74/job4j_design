package ru.job4j.tictactoe;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FieldTest {

    @Test
    public void whenThisCellLive() {
        Field field = new Field(3, null, null, null, null);
        field.fill();
        assertThat(field.validateCell("0", "X"), is(false));
    }

    @Test
    public void whenThisCellDontLive() {
        Field field = new Field(3, null, null, null, null);
        field.fill();
        assertThat(field.validateCell("9", "O"), is(true));
    }
}
