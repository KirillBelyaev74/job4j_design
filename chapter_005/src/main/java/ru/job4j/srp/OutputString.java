package ru.job4j.srp;

import java.io.*;

public class OutputString implements Output {

    private final String employees;

    public OutputString(String employees) {
        this.employees = employees;
    }

    @Override
    public void write(String nameFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile))) {
            bufferedWriter.write(this.employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
