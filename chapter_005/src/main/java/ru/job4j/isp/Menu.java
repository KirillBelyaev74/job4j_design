package ru.job4j.isp;

public class Menu {

    private double numberMenu;
    private String name;

    public Menu(double numberMenu, String name) {
        this.numberMenu = numberMenu;
        this.name = name;
    }

    public double getNumberMenu() {
        return numberMenu;
    }

    public void setNumberMenu(double numberMenu) {
        this.numberMenu = numberMenu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
