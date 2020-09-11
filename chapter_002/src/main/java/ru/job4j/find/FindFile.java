package ru.job4j.find;

import java.io.IOException;
import java.nio.file.*;

public class FindFile {

    public static void main(String[] args) throws IOException {

        SelectionArguments selectionArguments = new SelectionArguments(args);

        MySimpleFileVisitor mySimpleFileVisitor = new MySimpleFileVisitor(selectionArguments.getPredicate());

        Files.walkFileTree(Paths.get(selectionArguments.directory()), mySimpleFileVisitor);

        new WriteInFile().writeInFile(selectionArguments.writeInFileName(),mySimpleFileVisitor.getList());
    }
}
