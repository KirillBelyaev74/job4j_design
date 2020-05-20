package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> last;
    private int counter;
    private int modCount;

    public void add(T value) {
        this.modCount++;
        this.counter++;
        Node<T> node = new Node<T>(value, null, this.last);
        if (this.head == null) {
            this.head = node;
            this.last = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        this.last = node;
    }

    public Node get(int index) {
        Objects.checkIndex(index, this.counter);
        Node result = head;
        for (int i = 1; i <= index; i++) {
            result = result.next;
        }
        return result;
    }

    public T deleteFirst() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        this.modCount++;
        T del = this.head.value;
        this.head = this.head.next;
        return del;
    }

    public T deleteLast() {
        if (this.last == null) {
            throw new NoSuchElementException();
        }
        this.modCount++;
        T del = this.last.value;
        this.last = this.last.past;
        return del;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int expectedModCount = modCount;
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return this.node != null;
            }

            @Override
            public T next() {
                if (modCount  != this.expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = this.node.value;
                this.node = this.node.next;
                return value;
            }
        };
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> past;

        private Node(T value, Node<T> next, Node<T> past) {
            this.value = value;
            this.next = next;
            this.past = past;
        }

        public T getValue() {
            return this.value;
        }
    }
}
