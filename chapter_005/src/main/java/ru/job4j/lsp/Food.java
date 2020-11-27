package ru.job4j.lsp;

import java.util.Calendar;
import java.util.Objects;

public class Food {

    private String name;
    private Calendar createDate;
    private Calendar expiryDate;
    private double price;
    private int discount;

    public Food(String name, Calendar createDate, Calendar expiryDate, double price, int discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Food food = (Food) o;
        return price == food.price && discount == food.discount
                && name.equals(food.name)
                && createDate.equals(food.createDate)
                && expiryDate.equals(food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expiryDate, price, discount);
    }
}
