package ru.job4j.lsp;

import java.util.*;

public class Warehouse implements Storage {

    private List<Food> foods = new LinkedList<>();

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double lived = System.currentTimeMillis() - food.getCreateDate().getTimeInMillis();
        double life = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        boolean result = false;
        if (lived / life * 100 < 25) {
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> clear() {
        List<Food> food = new LinkedList<>(this.foods);
        this.foods.clear();
        return food;
    }
}
