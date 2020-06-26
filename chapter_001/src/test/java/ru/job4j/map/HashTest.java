package ru.job4j.map;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class HashTest {

    @Test
    public void whenAddInHash() {
        Hash<Integer, String> hash = new Hash<>();
        hash.insert(10, "Kirill");
        hash.insert(20, "Kostya");
        hash.insert(30, "Ivan");
        String result = hash.get(30);
        assertThat(result, is("Ivan"));
    }

    @Test
    public void whenChangeValue() {
        Hash<Integer, String> hash = new Hash<>();
        hash.insert(10, "Kirill");
        hash.insert(30, "Ivan");
        hash.insert(30, "Petr");
        String result = hash.get(30);
        assertThat(result, is("Petr"));
    }

    @Test
    public void whenDeleteOneElement() {
        Hash<Integer, String> hash = new Hash<>();
        hash.insert(10, "Kirill");
        hash.insert(20, "Kostya");
        hash.insert(30, "Ivan");
        hash.delete(20);
        String result = hash.get(20);
        assertThat(result, is(equalTo( null)));
    }

    @Test
    public void whenSizeHashDouble() {
        Hash<String, String> hash = new Hash<>();
        hash.insert("Kirill", "Kirill");
        hash.insert("Kostya", "Kostya");
        hash.insert("Ivan", "Ivan");
        hash.insert("Petr", "Petr");
        hash.insert("Mikhail", "Mikhail");
        hash.insert("Sergey", "Sergey");
        hash.insert("Dmitriy", "Dmitriy");
        assertThat(hash.getSize(), is(4));
    }

    @Test
    public void when() {
        Hash<Integer, String> hash = new Hash<>();
        hash.insert(10, "Kirill");
        hash.insert(20, "Kostya");
        hash.insert(30, "Ivan");
        Iterator iterator = hash.iterator();
        assertThat(iterator.next(), is("Ivan"));
        assertThat(iterator.next(), is("Kirill"));
    }
}
