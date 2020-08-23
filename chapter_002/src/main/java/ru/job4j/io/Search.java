package ru.job4j.io;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Search {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, "java").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searchFiles = new SearchFiles(ext);
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }
}