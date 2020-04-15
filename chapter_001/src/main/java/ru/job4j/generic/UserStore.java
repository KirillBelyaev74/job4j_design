package ru.job4j.generic;

public class UserStore<T extends Base> extends AbstractStore implements Store {

    public UserStore(int size) {
        super(size);
    }
}
