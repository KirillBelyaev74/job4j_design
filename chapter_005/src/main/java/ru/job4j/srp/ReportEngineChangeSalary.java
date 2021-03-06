package ru.job4j.srp;

import java.util.Objects;
import java.util.function.Predicate;

public class ReportEngineChangeSalary implements Report {

    private Store store;
    private StringBuilder stringBuilder = new StringBuilder();

    public ReportEngineChangeSalary(Store store) {
        this.store = store;
    }

    @Override
    public boolean reportFormat(Predicate<Employee> predicate) {
        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            this.stringBuilder
                    .append("Name; Hired; Fired; Salary;")
                    .append(System.lineSeparator())
                    .append(employee.getName()).append("; ")
                    .append(employee.getFired().getTime()).append("; ")
                    .append(employee.getHired().getTime()).append("; ")
                    .append(employee.getSalary() / 70).append(";")
                    .append(System.lineSeparator());
        }
        return this.stringBuilder != null;
    }

    public String getString() {
        return this.stringBuilder.toString();
    }
}
