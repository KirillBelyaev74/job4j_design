package ru.job4j.srp;

import org.json.simple.JSONObject;

import java.util.Objects;
import java.util.function.Predicate;

public class ReportInTheFormatJson implements Report {

    private final Store store;
    private JSONObject employees = new JSONObject();

    public ReportInTheFormatJson(Store store) {
        this.store = store;
    }

    @Override
    public boolean reportFormat(Predicate<Employee> predicate) {
        JSONObject children = new JSONObject();
        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            children.put("name", employee.getName());
            children.put("fired", employee.getFired().getTime().toString());
            children.put("hired", employee.getHired().getTime().toString());
            children.put("salary", employee.getSalary());
        }
        this.employees.put("employee", children);
        return this.employees != null;
    }

    public JSONObject getJsonObject() {
        return this.employees;
    }
}
