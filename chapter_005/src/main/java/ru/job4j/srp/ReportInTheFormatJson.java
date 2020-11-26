package ru.job4j.srp;

import org.json.simple.JSONObject;

import java.util.Objects;
import java.util.function.Predicate;

public class ReportInTheFormatJson {

    private final Store store;

    public ReportInTheFormatJson(Store store) {
        this.store = store;
    }

    public JSONObject reportFormat(Predicate<Employee> predicate) {
        JSONObject children = new JSONObject();
        JSONObject employees = new JSONObject();
        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            children.put("name", employee.getName());
            children.put("fired", employee.getFired().getTime().toString());
            children.put("hired", employee.getHired().getTime().toString());
            children.put("salary", employee.getSalary());
        }
        employees.put("employee", children);
        return employees;
    }
}
