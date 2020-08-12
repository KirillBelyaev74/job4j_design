package ru.job4j.io;
import java.io.*;
import java.util.*;

public class Analizy {

    public void findMistakes(String source, String target) throws IOException {
        boolean value = false;
        List<String> list = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!value & (line.contains("400") || line.contains("500"))) {
                    list.add(line.substring(line.indexOf(" ") + 1) + System.lineSeparator());
                    value = true;
                } else  if (value && (!line.contains("400") && !line.contains("500"))) {
                    list.add(line.substring(line.indexOf(" ") + 1) + System.lineSeparator());
                    value = false;
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        this.recordMistakes(target, list);
    }

    public void recordMistakes(String target, List<String> list) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            list.forEach(printWriter::write);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Analizy().findMistakes("with_errors.csv", "without_errors.csv");
    }
}