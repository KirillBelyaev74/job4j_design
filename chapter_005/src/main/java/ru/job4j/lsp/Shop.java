package ru.job4j.lsp;

import java.util.LinkedList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> foods = new LinkedList<>();

    @Override
    public void add(Food food) {
        this.foods.add(food);
    }

    @Override
    public boolean accept(Food food) {
        double lived = System.currentTimeMillis() - food.getCreateDate().getTimeInMillis();
        double life = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        double shelfLife = lived / life * 100;
        boolean result = false;
        if (25 < shelfLife && shelfLife < 75) {
            this.foods.add(food);
            result = true;
        } else if (75 < shelfLife) {
            double discount = food.getPrice() * (food.getDiscount() / 100D);
            food.setPrice(food.getPrice() - discount);
            this.foods.add(food);
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
