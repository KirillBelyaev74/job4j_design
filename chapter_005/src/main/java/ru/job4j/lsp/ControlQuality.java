package ru.job4j.lsp;

import java.util.*;

public class ControlQuality {

    private List<Storage> storages;

    public ControlQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void distribution(Food food) {
        for (Storage storage : this.storages) {
            if (storage.accept(food)) {
                storage.add(food);
            }
        }
    }

    public boolean resort() {
        boolean result = false;
        List<Food> foods = new LinkedList<>();
        for (Storage storage : this.storages) {
            foods.addAll(storage.clear());
        }
        if (!foods.isEmpty()) {
            result = true;
            for (Food food : foods) {
                this.distribution(food);
            }
        }
        return result;
    }
}
