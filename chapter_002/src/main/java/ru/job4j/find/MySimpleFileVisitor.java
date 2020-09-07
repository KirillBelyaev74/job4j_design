package ru.job4j.find;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Predicate;

public class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> list = new LinkedList<>();
    private Predicate<Path> predicate;

    public MySimpleFileVisitor(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public FileVisitResult visitFile(Path files, BasicFileAttributes attrs) {
        if (predicate.test(files)) {
            list.add(files);
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getList() {
        return this.list;
    }
}
