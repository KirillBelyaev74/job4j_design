package ru.job4j.srp;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;

public class ReportEngineTest {


    private final MemStore store = new MemStore();
    private final Calendar now = Calendar.getInstance();
    private final Employee worker = new Employee("Ivan", now, now, 100);
    private final ReportEngine engine = new ReportEngine(store);

    @Before
    public void start() {
        store.add(this.worker);
    }

    @Test
    public void whenOldGenerated() {
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(this.worker.getName()).append("; ")
                .append(this.worker.getHired().getTime()).append("; ")
                .append(this.worker.getFired().getTime()).append("; ")
                .append(this.worker.getSalary()).append(";")
                .append(System.lineSeparator());

        assertThat(this.engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenOldGeneratedChangeSalary() {
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(this.worker.getName()).append("; ")
                .append(this.worker.getHired().getTime()).append("; ")
                .append(this.worker.getFired().getTime()).append("; ")
                .append(this.worker.getSalary() / 70).append(";")
                .append(System.lineSeparator());

        assertThat(this.engine.generateChangeSalary(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGenerateToHtml() throws IOException {
        Report reportInTheFormat = new ReportInTheFormatHtml(this.store);
        String employeesString = reportInTheFormat.reportFormat(em -> true);
        new OutputString(employeesString).write("report.html");

        StringBuilder expect = new StringBuilder()
                .append("<html>")
                .append("<body>")
                .append("<div>")
                .append("Name; Hired; Fired; Salary;")
                .append("</div>")
                .append("<div>")
                .append(worker.getName()).append("; ")
                .append(worker.getFired().getTime()).append("; ")
                .append(worker.getHired().getTime()).append("; ")
                .append(worker.getSalary()).append(";")
                .append("</div>")
                .append("</body>")
                .append("</html>");

        String result = Files.readString(Paths.get("report.html"));
        assertThat(result, is(expect.toString()));
    }

    @Test
    public void whenGenerateToXml() throws IOException {
        ReportInTheFormatXml reportInTheFormat = new ReportInTheFormatXml(this.store);
        Document document = reportInTheFormat.reportFormat(e -> true);
        new OutputXml(document).write("report.xml");

        StringBuilder stringBuilder = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>")
                .append("<employee>")
                .append("<name>")
                .append(this.worker.getName())
                .append("</name>")
                .append("<hired>")
                .append(this.worker.getFired().getTime().toString())
                .append("</hired>")
                .append("<fired>")
                .append(this.worker.getHired().getTime().toString())
                .append("</fired>")
                .append("<salary>")
                .append(this.worker.getSalary())
                .append("</salary>")
                .append("</employee>");

        String result = Files.readString(Paths.get("report.xml"));
        assertThat(result, is(stringBuilder.toString()));
    }

    @Test
    public void whenGenerateToJson() throws IOException {
        ReportInTheFormatJson reportInTheFormatJson = new ReportInTheFormatJson(this.store);
        JSONObject jsonObject = reportInTheFormatJson.reportFormat(e -> true);
        new OutputString(jsonObject.toJSONString()).write("report.json");

        StringBuilder stringBuilder = new StringBuilder()
                .append("{\\\"employee\\\":")
                .append("{\\\"name\\\":\\\"")
                .append(this.worker.getName())
                .append("\\\",\\\"fired\\\":\\\"")
                .append(this.worker.getFired().getTime())
                .append("\\\",\\\"hired\\\":\\\"")
                .append(this.worker.getHired().getTime())
                .append("\\\",\\\"salary\\\":")
                .append(this.worker.getSalary())
                .append("}}\"");

        String result = Files.readString(Paths.get("report.json"));
        assertThat(stringBuilder, is(result));
    }
}
