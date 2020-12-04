package ru.job4j.isp;

import java.util.*;

public interface Item<Menu> {

    boolean add(Menu child, Menu parent);
    Optional<Node<Menu>> findBy(Menu parent);

    class Node<Menu> {

        private Menu menu;
        private List<Node<Menu>> menuChildren = new LinkedList<>();

        public Node(Menu menu) {
            this.menu = menu;
        }

        public Menu getMenu() {
            return menu;
        }

        public void setMenu(Menu menu) {
            this.menu = menu;
        }

        public List<Node<Menu>> getMenuChildren() {
            return menuChildren;
        }

        public void setMenuChildren(List<Node<Menu>> menuChildren) {
            this.menuChildren = menuChildren;
        }
    }

}
