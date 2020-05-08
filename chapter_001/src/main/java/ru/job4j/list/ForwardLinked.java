package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {

    private Node<T> head;
    private int counter;
    private int modCount;

    public void add(T value) {
        this.modCount++;
        this.counter++;
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
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
        if (head == null) {
            throw new NoSuchElementException();
        }
        this.modCount++;
        T del = head.value;
        head = head.next;
        return del;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int expectedModCount = modCount;
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (modCount  != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;

        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }
    }
}
