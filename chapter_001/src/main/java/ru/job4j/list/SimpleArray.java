package ru.job4j.list;
import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[3];
    private int counter;
    private int modCount;

    public void add(T model) {
        if (this.container.length == this.counter) {
            this.container = Arrays.copyOf(this.container, container.length * 2);
        }
        this.container[this.counter++] = model;
        this.modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.counter);
        return (T) this.container[index];
    }

    @Override
    public Iterator<T> iterator() {

        int expectedModCount = this.modCount;

        return new Iterator<T>() {
            int indicator;

            @Override
            public boolean hasNext() {
                return this.indicator < counter;
            }

            @Override
            public T next() {
                if (modCount  != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[this.indicator++];
            }
        };
    }
}