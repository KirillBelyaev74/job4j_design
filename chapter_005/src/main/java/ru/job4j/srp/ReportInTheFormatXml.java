package ru.job4j.srp;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.Objects;
import java.util.function.Predicate;

public class ReportInTheFormatXml implements Report{

    private Store store;
    private Document document;

    public ReportInTheFormatXml(Store store) {
        this.store = store;
    }

    public void createDocument() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            this.document = documentBuilder.newDocument();
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        }
    }

    public boolean reportFormat(Predicate<Employee> predicate) {

        this.createDocument();

        Element elementEmployee = this.document.createElement("employee");
        Element elementName = this.document.createElement("name");
        Element elementHired = this.document.createElement("hired");
        Element elementFired = this.document.createElement("fired");
        Element elementSalary = this.document.createElement("salary");

        this.document.appendChild(elementEmployee);
        elementEmployee.appendChild(elementName);
        elementEmployee.appendChild(elementHired);
        elementEmployee.appendChild(elementFired);
        elementEmployee.appendChild(elementSalary);

        for (Employee employee : Objects.requireNonNull(this.store.findBy(predicate))) {
            elementName.setTextContent(employee.getName());
            elementHired.setTextContent(employee.getHired().getTime().toString());
            elementFired.setTextContent(employee.getFired().getTime().toString());
            elementSalary.setTextContent(String.valueOf(employee.getSalary()));
        }
        return this.document != null;
    }

    public Document getDocument() {
        return this.document;
    }
}
