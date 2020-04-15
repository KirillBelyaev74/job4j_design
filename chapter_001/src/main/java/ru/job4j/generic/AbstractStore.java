package ru.job4j.generic;

public abstract class AbstractStore<T extends Base>  implements Store{

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
        int idInt = Integer.parseInt(id);
        return (idInt >= 0 && idInt < this.size) && (this.base.set(idInt, model));
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int idInt = Integer.parseInt(id);
        if (idInt >= 0 && idInt < this.size) {
            this.base.remove(idInt);
            this.size--;
            result = true;
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        int idInt = Integer.parseInt(id);
        return idInt >= 0 && idInt < this.size && this.base.get(idInt) != null ? (Base) this.base.get(idInt) : null;
    }
}
