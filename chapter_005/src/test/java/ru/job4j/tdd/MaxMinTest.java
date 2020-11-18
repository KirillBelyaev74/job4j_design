package ru.job4j.tdd;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        MaxMin maxMin = new MaxMin();
        int result = maxMin.max(List.of(2, 5, 3, 1, 4), (Integer::compareTo));
        assertThat(result, is(5));
    }

    @Test
    public void min() {
        MaxMin maxMin = new MaxMin();
        int result = maxMin.min(List.of(3, 2, 5, 1, 4), ((o1, o2) -> o2 - o1));
        assertThat(result, is(1));
    }
}