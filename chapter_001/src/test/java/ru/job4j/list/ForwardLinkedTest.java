package ru.job4j.list;
import org.junit.Test;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ForwardLinkedTest {

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenMultiDelete() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.deleteFirst();
        linked.deleteFirst();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(3));
    }

    @Test
    public void whenGetFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(10);
        linked.add(20);
        linked.add(30);
        assertThat(linked.get(0).getValue(), is(10));
        assertThat(linked.get(1).getValue(), is(20));
        assertThat(linked.get(2).getValue(), is(30));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(10);
        Iterator it = linked.iterator();
        linked.add(20);
        it.next();
    }

    @Test
    public void when() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(10);
        linked.add(20);
        linked.add(30);
        assertThat(linked.deleteLast(), is(30));
        assertThat(linked.deleteLast(), is(20));
        assertThat(linked.deleteLast(), is(10));
    }
}
