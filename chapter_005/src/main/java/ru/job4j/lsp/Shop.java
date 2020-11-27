package ru.job4j.lsp;

import java.util.LinkedList;
import java.util.List;

public class Shop implements Place {

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
