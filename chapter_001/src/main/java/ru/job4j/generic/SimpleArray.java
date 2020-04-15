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
        boolean result = false;
        if (index >= 0 && index < this.position) {
            this.array[index] = model;
            result = true;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return result;
    }

    public boolean remove(int index) {
        boolean result = false;
        if (index >= 0 && index < this.position) {
            System.arraycopy(this.array, index + 1, this.array, index, (this.position - 1) - index);
            this.position--;
            result = true;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return result;
    }

    public Object get(int index) {
        Object result = null;
        if (index >= 0 && index < this.position) {
            result = this.array[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return result;
    }

    @Override
    public Iterator iterator() {
        return new SimpleArrayIterator<T>(this.array);
    }
}
