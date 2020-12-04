package ru.job4j.isp;

import java.util.*;

public class AddItem<Menu> implements Item<Menu> {

    private Node<Menu> node;

    public AddItem(Menu menu) {
        this.node = new Node<>(menu);
    }

    @Override
    public boolean add(Menu parent, Menu child) {
        boolean result = false;
        Optional<Node<Menu>> menuNode = findBy(parent);
        if (menuNode.isPresent()) {
            menuNode.get().getMenuChildren().add(new Node<>(child));
            result = true;
        }
        return result;
    }

    @Override
    public Optional<Node<Menu>> findBy(Menu parent) {
        Optional<Node<Menu>> result = Optional.empty();
        Queue<Node<Menu>> data = new LinkedList<>();
        data.offer(this.node);
        while (!data.isEmpty()) {
            Node<Menu> element = data.poll();
            if (element.getMenu().equals(parent)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.getMenuChildren());
        }
        return result;
    }
}
