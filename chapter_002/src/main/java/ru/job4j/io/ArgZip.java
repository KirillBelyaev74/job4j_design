package ru.job4j.io;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.*;

public class ArgZip {

    private Map<String, String> argsMap = new HashMap<>();

    public ArgZip(String[] args) {
        for (String arg : args) {
            if (arg.contains("=")) {
                int index = arg.indexOf("=");
                argsMap.put(arg.substring(0, index), arg.substring(index + 1));
            }
        }
    }

    public String directory() throws FileNotFoundException {
        String tree = this.argsMap.get("-d");
        if (tree == null) {
            throw new IllegalArgumentException();
        } else if (!Files.exists(Paths.get(tree))) {
            throw new FileNotFoundException();
        }
        return tree;
    }

    public String exclude() {
        String exception = this.argsMap.get("-e");
        if (exception == null) {
            throw new IllegalArgumentException();
        }
        return exception;
    }

    public String output() {
        String nameZip = this.argsMap.get("-o");
        if (nameZip == null) {
            throw new IllegalArgumentException();
        }
        return nameZip;
    }
}
