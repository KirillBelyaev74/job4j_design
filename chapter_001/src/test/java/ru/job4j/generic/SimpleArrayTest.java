package ru.job4j.generic;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    SimpleArray<Integer> simpleArray;

    @Before
    public void start() {
        simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
    }

    @Test
    public void whenGetAllThreeInteger() {
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
        assertThat(simpleArray.get(2), is(3));
    }

    @Test
    public void whenChangeTwoIndex() {
        simpleArray.set(1, 9);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(9));
        assertThat(simpleArray.get(2), is(3));
    }

    @Test
    public void whenDeleteTwoIndex() {
        simpleArray.remove(2);
        assertThat(simpleArray.get(0), is(1));
        assertThat(simpleArray.get(1), is(2));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenToAddThenMistake() {
        simpleArray.add(4);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenToGetThenMistake() {
        simpleArray.get(3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenToRemoveThenMistake() {
        simpleArray.remove(3);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenToSetThenMistake() {
        simpleArray.set(3, 9);
    }


}
