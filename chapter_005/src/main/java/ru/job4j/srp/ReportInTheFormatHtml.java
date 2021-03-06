package ru.job4j.srp;

import java.util.Objects;
import java.util.function.Predicate;

public class ReportInTheFormatHtml implements Report {

    private final Store store;
    private StringBuilder stringBuilder = new StringBuilder();

    public ReportInTheFormatHtml(Store store) {
        this.store = store;
    }

    @Override
    public boolean reportFormat(Predicate<Employee> predicate) {
        this.stringBuilder.append("<html>").append("<body>");
        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            this.stringBuilder
                    .append("<div>")
                    .append("Name; Hired; Fired; Salary;")
                    .append("</div>")
                    .append("<div>")
                    .append(employee.getName()).append("; ")
                    .append(employee.getFired().getTime()).append("; ")
                    .append(employee.getHired().getTime()).append("; ")
                    .append(employee.getSalary()).append(";")
                    .append("</div>");
        }
        this.stringBuilder.append("</body>").append("</html>");
        return this.stringBuilder != null;
    }

    public String getString() {
        return this.stringBuilder.toString();
    }
}
