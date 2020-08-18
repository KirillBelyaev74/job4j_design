package ru.job4j.tree;
import java.util.*;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {

    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> treeNode = findBy(element -> element.value.equals(parent));
        if (treeNode.isPresent() && findBy(element -> element.value.equals(child)).isEmpty()) {
            treeNode.get().children.add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(Predicate<Node<E>> predicate) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (predicate.test(element)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }
        return result;
    }

    public boolean isBinary() {
        Optional<Node<E>> result = this.findBy(element -> element.children.size() > 2);
        return result.isEmpty();
    }
}