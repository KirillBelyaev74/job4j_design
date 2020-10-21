package ru.job4j.map;

import java.util.Iterator;
import java.util.Objects;

public class Node<K, V> {
    private K key;
    private V value;
    private Node<K, V> next;
    private Node<K, V> previous;

    public Node(K key, V value, Node<K, V> next, Node<K, V> previous) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(key, node.key) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
