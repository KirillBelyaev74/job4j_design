package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store {

    private SimpleArray<Base> elements;
    private int size;

    public AbstractStore(int size) {
        this.elements = new SimpleArray<>(size);
        this.size = size;
    }

    @Override
    public void add(Base model) {
        this.elements.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        int index = this.findIndex(id);
        return index != -1 && this.elements.set(index, model);
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndex(id);
        if (index != -1) {
            this.elements.remove(index);
            this.size--;
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        int index = this.findIndex(id);
        return index != -1 ? this.elements.get(index) : null;
    }

    private int findIndex(String id) {
        int index = -1;
        for (int i = 0; i != this.size; i++) {
            if (this.elements.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
