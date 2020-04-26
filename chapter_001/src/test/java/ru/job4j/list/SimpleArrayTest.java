package ru.job4j.list;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        assertThat(array.get(0), is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        assertThat(array.iterator().next(), is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleArray<String> array = new SimpleArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }

    @Test
    public void whenTheArrayIsFull() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("fourth");
        assertThat(array.get(0), is("first"));
        assertThat(array.get(1), is("second"));
        assertThat(array.get(2), is("third"));
        assertThat(array.get(3), is("fourth"));
    }
}