package ru.job4j.srp;

import java.util.Objects;
import java.util.function.Predicate;

public class ReportInTheFormatHtml implements Report {

    private final Store store;

    public ReportInTheFormatHtml(Store store) {
        this.store = store;
    }

    @Override
    public String reportFormat(Predicate<Employee> predicate) {
        StringBuilder stringBuilder = new StringBuilder()
                .append("<html>").append("<body>");
        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            stringBuilder
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
        stringBuilder.append("</body>").append("</html>");
        return stringBuilder.toString();
    }
}
