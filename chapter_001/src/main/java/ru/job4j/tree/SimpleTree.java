package ru.job4j.tree;
import java.util.*;
import java.util.function.Predicate;

public interface SimpleTree<E> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(Predicate<Node<E>> predicate);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        Node(E value) {
            this.value = value;
        }
    }
}
