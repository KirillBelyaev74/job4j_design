package ru.job4j.generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {

    private int position;
    private Object[] array;

    public SimpleArray(int position) {
        this.array = new Object[position];
    }

    public void add(T model) {
        Objects.checkIndex(this.position, this.array.length);
        this.array[this.position++] = model;
    }

    public boolean set(int index, T model) {
        Objects.checkIndex(index, this.position);
        this.array[index] = model;
        return true;
    }

    public boolean remove(int index) {
        Objects.checkIndex(index, this.position);
        System.arraycopy(this.array, index + 1, this.array, index, (this.position - 1) - index);
        this.position--;
        return true;
    }

    public T get(int index) {
        Objects.checkIndex(index, this.position);
        return (T) this.array[index];
    }

    @Override
    public Iterator iterator() {
        return new SimpleArrayIterator<T>(this.array);
    }
}
