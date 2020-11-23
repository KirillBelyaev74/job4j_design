package ru.job4j.srp;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Predicate;

public class ReportEngine {

    private Store store;
    private Predicate<Employee> predicate;
    private StringBuilder stringBuilder = new StringBuilder();

    public ReportEngine(Store store, Predicate<Employee> predicate) {
        this.store = store;
        this.predicate = predicate;
    }

    public String generate() {
        for (Employee employee : Objects.requireNonNull(this.store.findBy(this.predicate))) {
            this.employeesToString(employee);
        }
        return this.stringBuilder.toString();
    }

    public String generateHtml() {
        this.stringBuilder.append("<html>").append("<body>");
        for (Employee employee : Objects.requireNonNull(this.store.findBy(this.predicate))) {
            this.stringBuilder.append("<div>");
            this.employeesToString(employee);
            this.stringBuilder.append("</div>");
        }
        this.stringBuilder.append("</body>").append("</html>");
        return this.stringBuilder.toString();
    }

    public String generateChangeSalary() {
        for (Employee employee : Objects.requireNonNull(this.store.findBy(this.predicate))) {
            employee.setSalary(employee.getSalary() / 70);
            this.employeesToString(employee);
        }
        return this.stringBuilder.toString();
    }

    public void employeesToString(Employee employee) {
        this.stringBuilder
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee.getName()).append("; ")
                .append(employee.getFired().getTime()).append("; ")
                .append(employee.getHired().getTime()).append("; ")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator());
    }
}
