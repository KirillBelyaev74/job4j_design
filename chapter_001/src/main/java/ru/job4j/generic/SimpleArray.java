package ru.job4j.generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable {

    private int position;
    private Object[] array;

    public SimpleArray(int position) {
        this.array = new Object[position];
    }

    public void add(T model) {
        if (this.position > this.array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[this.position++] = model;
    }

    public boolean set(int index, T model) {
        if (index < 0 && index > this.position) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[index] = model;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 && index > this.position) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(this.array, index + 1, this.array, index, (this.position - 1) - index);
        this.position--;
        return true;
    }

    public Object get(int index) {
        if (index < 0 && index > this.position) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    @Override
    public Iterator iterator() {
        return new SimpleArrayIterator<T>(this.array);
    }
}
