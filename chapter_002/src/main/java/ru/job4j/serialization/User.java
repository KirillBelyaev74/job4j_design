package ru.job4j.serialization;

import java.util.Calendar;

public class User {

    private final String name;
    private final Calendar birthday;
    private final boolean sexMan;
    private final int age;

    public User(String name, Calendar birthday, boolean sexMan, int age) {
        this.name = name;
        this.birthday = birthday;
        this.sexMan = sexMan;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public boolean isSexMan() {
        return sexMan;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", birthday=" + birthday
                + ", sexMan=" + sexMan
                + ", age=" + age
                + '}';
    }
}
