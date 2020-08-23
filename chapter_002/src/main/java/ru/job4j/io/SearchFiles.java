package ru.job4j.io;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFiles extends SimpleFileVisitor<Path> {

    private List<Path> list = new LinkedList<>();
    private String fileName;

    public SearchFiles(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path files, BasicFileAttributes attrs) throws IOException {
        File file = files.toFile();
        if (file.getName().endsWith(fileName)) {
            list.add(file.toPath());
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return CONTINUE;
    }

    public List<Path> getPaths() {
        return this.list;
    }
}
