package ru.job4j.list;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T popFirst() {
        return this.linked.deleteFirst();
    }

    public T popLast() {
        return this.linked.deleteLast();
    }

    public void push(T value) {
        this.linked.add(value);
    }

    public int getSize() {
        return this.linked.getCounter();
    }
}