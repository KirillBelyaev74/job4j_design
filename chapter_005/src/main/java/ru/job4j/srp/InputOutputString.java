package ru.job4j.srp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InputOutputString {

    public void writeHtml(String employeesString) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("report.html"))) {
            bufferedWriter.write(employeesString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
