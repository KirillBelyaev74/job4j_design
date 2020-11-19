package ru.job4j.tdd;

import java.util.Calendar;
import java.util.Map;

public interface Session {
    Map<Integer, Integer> freeSpace(Calendar calendar);
    Map<Integer, Integer> buzySpace(Calendar calendar);
}
