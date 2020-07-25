package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main(String[] args) throws IOException {
        List<String> log = filter("404");
        log.forEach(System.out::println);
    }
}
