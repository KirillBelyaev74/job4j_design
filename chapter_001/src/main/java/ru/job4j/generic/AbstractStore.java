package ru.job4j.generic;

public abstract class AbstractStore<T extends Base> implements Store {

    private SimpleArray<Base> base;
    private int size;

    public AbstractStore(int size) {
        this.base = new SimpleArray<>(size);
        this.size = size;
    }

    @Override
    public void add(Base model) {
        this.base.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        return this.base.set(this.findIndex(id), model);
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndex(id);
        if (index != -1) {
            this.base.remove(index);
            this.size--;
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        int index = this.findIndex(id);
        return index != -1 ? (Base) this.base.get(index) : null;
    }

    private int findIndex(String id) {
        int index = -1;
        for (int i = 0; i != this.size; i++) {
            if (((Base) this.base.get(i)).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
