package ru.job4j.io;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class Search {

    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searchFiles = new SearchFiles(ext);
        Files.walkFileTree(root, searchFiles);
        return searchFiles.getPaths();
    }

    public static void start(String[] args) throws IOException {
        validate(args);
        Path start = Paths.get(args[0]);
        search(start, args[1]).forEach(System.out::println);
    }

    public static void validate(String[] args) throws FileNotFoundException {
        if (!(args.length == 2)) {
            throw new IllegalArgumentException();
        }
        if (args[0] == null && args[1] == null) {
            throw new IllegalArgumentException();
        }
        if (!Files.exists(Paths.get(args[0]))) {
            throw new FileNotFoundException();
        }
    }

    public static void main(String[] args) throws IOException {
        start(args);
    }
}