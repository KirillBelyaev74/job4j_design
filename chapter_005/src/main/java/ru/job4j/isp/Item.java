package ru.job4j.isp;

import java.util.LinkedList;
import java.util.List;

public interface Item<E> {

    void add(E menu);

    class Node<E> {

        private E menu;
        private List<E> menuChildren = new LinkedList<>();

        public Node(E menu) {
            this.menu = menu;
        }

        public E getMenu() {
            return menu;
        }

        public void setMenu(E menu) {
            this.menu = menu;
        }

        public List<E> getMenuChildren() {
            return menuChildren;
        }

        public void setMenuChildren(List<E> menuChildren) {
            this.menuChildren = menuChildren;
        }
    }

}
