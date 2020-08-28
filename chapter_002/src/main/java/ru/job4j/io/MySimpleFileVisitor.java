package ru.job4j.io;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Predicate;

class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> list = new LinkedList<>();
    private String directory;
    private Predicate<Path> predicate;

    public MySimpleFileVisitor(String directory, Predicate<Path> predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    public FileVisitResult visitFile(Path files, BasicFileAttributes attrs) {
        if (this.predicate.test(files)) {
            this.list.add(Paths.get(this.directory).relativize(files));
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFiles() {
        return this.list;
    }
}
