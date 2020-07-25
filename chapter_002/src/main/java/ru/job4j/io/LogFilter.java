package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) throws IOException {
        List<String> result = null;
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            result = in.lines().filter(s -> s.contains("404")).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void save(List<String> log, String file) throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            log.forEach(s -> printWriter.write(s + "\r"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}
