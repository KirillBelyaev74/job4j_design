package ru.job4j.set;
import org.junit.Test;
import java.util.Iterator;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    @Test
    public void whenAddSet() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(3);
        simpleSet.add(3);
        simpleSet.add(4);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.next(), is(4));
    }
}
