package ru.job4j.isp;

import java.util.Objects;

public class Menu {

    private String numberMenu;
    private String name;

    public Menu(String numberMenu, String name) {
        this.numberMenu = numberMenu;
        this.name = name;
    }

    public String getNumberMenu() {
        return numberMenu;
    }

    public void setNumberMenu(String numberMenu) {
        this.numberMenu = numberMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(numberMenu, menu.numberMenu) && Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberMenu, name);
    }

    @Override
    public String toString() {
        return numberMenu + "." + " " + name;
    }
}
