package ru.job4j.generic;

public class RoleStore<T extends Base> extends AbstractStore implements Store {

    public RoleStore(int size) {
        super(size);
    }
}
