package ru.job4j.generic;

import java.util.Iterator;

public class SimpleArrayIterator<T> implements Iterator {

    private Object[] array;
    private int position;

    public SimpleArrayIterator(Object[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return this.array.length != this.position;
    }

    @Override
    public Object next() {
        return this.hasNext() ? (T) this.array[this.position++] : null;
    }
}
