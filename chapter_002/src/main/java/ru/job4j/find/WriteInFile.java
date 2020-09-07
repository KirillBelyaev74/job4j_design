package ru.job4j.find;
import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class WriteInFile {

    public void writeInFile(String fileName, List<Path> list) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            list.forEach(element -> printWriter.write(element.getFileName() + System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
