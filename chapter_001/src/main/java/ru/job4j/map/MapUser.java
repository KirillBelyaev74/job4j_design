package ru.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class MapUser {

    private Map<User, Object> map = new HashMap<>();

    public void compareUser(User user) {
        this.map.put(user, new Object());
    }

    public Map<User, Object> getMap() {
        return this.map;
    }
}
