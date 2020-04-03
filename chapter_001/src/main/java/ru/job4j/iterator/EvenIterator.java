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
        boolean result = false;
        if (this.check() != -1) {
            result = true;
            this.index--;
        }
        return result;
    }

    @Override
    public Object next() {
        int result = this.check();
        if (result == -1) {
            throw new NoSuchElementException();
        }
        return result;

    }

    private int check() {
        int result = -1;
        for (; this.index != this.arr.length; this.index++) {
            if (this.arr[this.index] % 2 == 0) {
                result = this.arr[this.index++];
                break;
            }
        }
        return result;
    }
}