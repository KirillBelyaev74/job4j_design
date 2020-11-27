package ru.job4j.lsp;

import java.util.*;

public class Warehouse implements Place {

    private List<Food> foods = new LinkedList<>();

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public List<Food> getFoods() {
        return this.foods;
    }
}
