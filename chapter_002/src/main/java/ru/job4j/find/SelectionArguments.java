package ru.job4j.find;
import java.io.FileNotFoundException;
import java.nio.file.*;

public class SelectionArguments {

    private String[] arguments;

    public SelectionArguments(String[] arguments) {
        if (arguments == null) {
            throw new IllegalArgumentException();
        }
        this.arguments = arguments;
    }

    public String directory() throws FileNotFoundException {
        String directory = null;
        for (int index = 0; index != this.arguments.length; index++) {
            if (this.arguments[index].equalsIgnoreCase("-d")) {
                directory = this.arguments[index + 1];
                break;
            }
        }
        if (directory == null && !Files.exists(Paths.get(directory))) {
            throw new FileNotFoundException();
        }
        return directory;
    }

    public String findFileName() {
        String nameFile = null;
        for (int index = 0; index != this.arguments.length; index++) {
            if (this.arguments[index].equalsIgnoreCase("-n")) {
                nameFile = this.arguments[index + 1];
                break;
            }
        }
        if (nameFile == null) {
            throw new IllegalArgumentException();
        }
        return nameFile.replace("*", "");
    }

    public String writeInFileName() {
        String writeInFileName = null;
        for (int index = 0; index != this.arguments.length; index++) {
            if (this.arguments[index].equalsIgnoreCase("-o")) {
                writeInFileName = this.arguments[index + 1];
                break;
            }
        }
        if (writeInFileName == null) {
            throw new IllegalArgumentException();
        }
        return writeInFileName;
    }
}
