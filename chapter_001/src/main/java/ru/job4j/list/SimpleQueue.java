package ru.job4j.list;

public class SimpleQueue<T> {

    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        while (this.in.getSize() == 0) {
            this.out.push(this.in.popFirst());
        }
        return this.in.popFirst();
    }

    public void push(T value) {
        this.in.push(value);
    }
}
