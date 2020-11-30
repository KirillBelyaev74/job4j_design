package ru.job4j.lsp;

import java.util.List;

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
}
