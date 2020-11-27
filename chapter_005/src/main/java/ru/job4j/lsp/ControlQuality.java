package ru.job4j.lsp;

public class ControlQuality {

    private Place warehouse;
    private Place shop;
    private Place trash;

    public ControlQuality(Place warehouse, Place shop, Place trash) {
        this.warehouse = warehouse;
        this.shop = shop;
        this.trash = trash;
    }

    public void distribution(Food food) {
        if (food == null) {
            throw new NullPointerException();
        }
        double lived = System.currentTimeMillis() - food.getCreateDate().getTimeInMillis();
        double life = food.getExpiryDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis();
        this.checkingDate(lived / life * 100, food);
    }

    public void checkingDate(double shelfLife, Food food) {
        if (shelfLife < 25) {
            this.warehouse.add(food);
        } else if (25 < shelfLife && shelfLife < 75) {
            this.trash.add(food);
        } else if (75 < shelfLife) {
            double discount = food.getPrice() * (food.getDiscount() / 100D);
            food.setPrice(food.getPrice() - discount);
            this.shop.add(food);
        } else {
            this.trash.add(food);
        }
    }
}
