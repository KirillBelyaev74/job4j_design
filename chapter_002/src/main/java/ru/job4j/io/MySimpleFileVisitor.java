package ru.job4j.io;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

class MySimpleFileVisitor extends SimpleFileVisitor<Path> {

    private List<Path> list = new LinkedList<>();
    private String exclude;
    private String directory;

    public MySimpleFileVisitor(String exclude, String directory) {
        this.exclude = exclude;
        this.directory = directory;
    }

    @Override
    public FileVisitResult visitFile(Path files, BasicFileAttributes attrs) throws IOException {
        String fileName = files.toAbsolutePath().normalize().toString();
        if (!files.toFile().getName().endsWith(this.exclude) && !fileName.contains("\\.git\\") && !fileName.contains("\\.idea\\")) {
            this.list.add(Paths.get(this.directory).relativize(files));
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFiles() {
        return this.list;
    }
}
