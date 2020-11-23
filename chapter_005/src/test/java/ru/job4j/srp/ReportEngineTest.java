package ru.job4j.srp;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store, em -> true);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired().getTime()).append("; ")
                .append(worker.getFired().getTime()).append("; ")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(), is(expect.toString()));
    }

    @Test
    public void whenGenerateToHtml() throws IOException {
        MemStore store = new MemStore();
        ReportEngine engine = new ReportEngine(store, em -> true);
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        InputOutputString inputOutputString = new InputOutputString();
        inputOutputString.writeHtml(engine.generateHtml());
        String result = Files.readString(Paths.get("report.html"));
        StringBuilder expect = new StringBuilder()
                .append("<html>").append("<body>")
                .append("<div>")
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getFired().getTime()).append("; ")
                .append(worker.getHired().getTime()).append("; ")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append("</div>")
                .append("</body>").append("</html>");
        assertThat(result, is(expect.toString()));
    }

    @Test
    public void whenOldGeneratedChangeSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        ReportEngine engine = new ReportEngine(store, e -> true);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append("; ")
                .append(worker.getHired().getTime()).append("; ")
                .append(worker.getFired().getTime()).append("; ")
                .append(worker.getSalary() / 70).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generateChangeSalary(), is(expect.toString()));
    }}
