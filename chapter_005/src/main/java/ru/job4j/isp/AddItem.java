package ru.job4j.isp;
import java.util.*;

public class AddItem<Menu> implements Item<Menu> {

    private List<Node<Menu>> nodes = new LinkedList<>();

    @Override
    public boolean addParent(Menu menu) {
        return nodes.add(new Node<>(menu));
    }

    @Override
    public boolean addChild(Menu parent, Menu child) {
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
        Iterator iterator = this.nodes.iterator();
        while (result.isEmpty() && iterator.hasNext() ) {
            data.offer((Node<Menu>) iterator.next());
            while (!data.isEmpty()) {
                Node<Menu> element = data.poll();
                if (element.getMenu().equals(parent)) {
                    result = Optional.of(element);
                    break;
                }
                data.addAll(element.getMenuChildren());
            }
        }
        return result;
    }

    public void printMenu() {
        for (Node<Menu> nodes : this.nodes) {
            Node<Menu> node = nodes;
            System.out.println(node.getMenu().toString());
            if (!node.getMenuChildren().isEmpty()) {
                for (Node<Menu> iteratorNode : node.getMenuChildren()) {
                    System.out.println(iteratorNode.getMenu().toString());
                }
            }
        }
    }
}