package ru.job4j.set;
import ru.job4j.list.SimpleArray;

import java.util.*;

public class SimpleSet<T> implements Iterable {

    private SimpleArray<T> array = new SimpleArray<>();

    public void add(T t) {
        if (this.array.contains(t)) {
            this.array.add(t);
        }
    }

    @Override
    public Iterator iterator() {
        return this.array.iterator();
    }
}
