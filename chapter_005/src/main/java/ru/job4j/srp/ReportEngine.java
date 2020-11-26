package ru.job4j.srp;
import java.util.Objects;
import java.util.function.Predicate;

public class ReportEngine {

    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            stringBuilder.append(this.employeesToString(employee));
        }
        return stringBuilder.toString();
    }

    public String generateChangeSalary(Predicate<Employee> predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            employee.setSalary(employee.getSalary() / 70);
            stringBuilder.append(this.employeesToString(employee));
        }
        return stringBuilder.toString();
    }

    public String employeesToString(Employee employee) {
        return new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee.getName()).append("; ")
                .append(employee.getFired().getTime()).append("; ")
                .append(employee.getHired().getTime()).append("; ")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator())
                .toString();
    }
}
