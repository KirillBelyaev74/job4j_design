package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return this.findValue(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return this.findValue(value, comparator);
    }

    public <T> T findValue (List<T> value, Comparator<T> comparator) {
        T result = value.get(0);
        int index = 1;
        while (index != (value.size())) {
            if (comparator.compare(result, value.get(index)) < 0) {
                result = value.get(index);
            }
            index++;
        }
        return result;
    }
}
