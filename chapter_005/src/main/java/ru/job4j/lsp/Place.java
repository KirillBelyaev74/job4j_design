package ru.job4j.lsp;

import java.util.List;

interface Place {
    void add(Food food);
    List<Food> getFoods();
}
