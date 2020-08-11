package ru.job4j.io;
import java.io.*;

public class Analizy {

    public void unavailable(String source, String target) throws IOException {
        boolean value = false;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
             PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!value & (line.contains("400") || line.contains("500"))) {
                    printWriter.write(line.substring(line.indexOf(" ")));
                    printWriter.write(System.lineSeparator());
                    value = true;
                } else  if (value && (!line.contains("400") && !line.contains("500"))) {
                    printWriter.write(line.substring(line.indexOf(" ")));
                    printWriter.write(System.lineSeparator());
                    value = false;
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Analizy().unavailable("with_errors.csv", "without_errors.csv");
    }
}