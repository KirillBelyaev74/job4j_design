package ru.job4j.srp;

import java.util.function.Predicate;

public interface Report {
    boolean reportFormat(Predicate<Employee> predicate);
}
