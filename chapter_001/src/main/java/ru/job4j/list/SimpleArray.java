package ru.job4j.list;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[3];
    private int counter;

    public void add(T model) {
        if (this.container.length == this.counter) {
            Object[] container = new Object[this.container.length * 2];
            System.arraycopy(this.container, 0, container, 0, this.counter);
            this.container = container;
        }
        this.container[this.counter++] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.counter);
        return (T) this.container[index];
    }

    @Override
    public Iterator<T> iterator() {

        int expectedModCount = counter;

        return new Iterator<T>() {
            int indicator;

            @Override
            public boolean hasNext() {
                return this.indicator < counter;
            }

            @Override
            public T next() {
                if (counter != expectedModCount) {
                    throw new ConcurrentModificationException();
                } else if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[this.indicator++];
            }
        };
    }
}