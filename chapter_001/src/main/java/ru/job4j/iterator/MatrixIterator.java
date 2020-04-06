package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private int arr[][];
    private int x;
    private int y;
    private int result;

    public MatrixIterator(int[][] arr) {
        this.arr = arr;
    }

    public boolean hasNext() {
        return this.arr[y].length >= this.x && this.arr.length - 1 != this.y;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (x != this.arr[y].length) {
            this.result = this.arr[y][x++];
        } else {
            this.x = 0;
            this.y++;
            this.result = this.arr[y][x++];
        }
        return result;
    }

    public void remove() {
    }
}
