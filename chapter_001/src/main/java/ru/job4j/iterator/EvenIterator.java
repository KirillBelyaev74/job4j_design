package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator {

    private int[] arr;
    private int index;

    public EvenIterator(int[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return this.check();
    }

    @Override
    public Object next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.arr[this.index++];
    }

    private boolean check() {
        boolean result = false;
        for (; this.index != this.arr.length; this.index++) {
            if (this.arr[this.index] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }
}
