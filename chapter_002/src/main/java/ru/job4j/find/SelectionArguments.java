package ru.job4j.find;
import java.io.FileNotFoundException;
import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;

public class SelectionArguments {

    private Map<String, String> args = new HashMap<>();

    public SelectionArguments(String[] arguments) {
        if (arguments == null) {
            throw new IllegalArgumentException();
        }
        this.validate(arguments);
    }

    public void validate(String[] arguments) {
        for (int index = 0; index != arguments.length; index++) {
            if (arguments[index].contains("-") && !arguments[index + 1].contains("-")) {
                this.args.put(arguments[index], arguments[index + 1]);
                index++;
            } else if (arguments[index].contains("-") && arguments[index + 1].contains("-")) {
                this.args.put(arguments[index], null);
            }
        }
    }

    public String directory() throws FileNotFoundException {
        String directory = args.get("-d");
        if (directory == null) {
            throw new IllegalArgumentException();
        } else if (!Files.exists(Paths.get(directory))) {
            throw new FileNotFoundException();
        }
        return directory;
    }

    public String findFileName() {
        String findName = this.args.get("-n");
        if (findName == null) {
            throw new IllegalArgumentException();
        }
        return findName;
    }

    public String writeInFileName() {
        String writeFileName = this.args.get("-o");
        if (writeFileName == null) {
            throw new IllegalArgumentException();
        }
        return writeFileName;
    }

    public Predicate<Path> getPredicate() {
        Predicate<Path> result = null;
        String key = this.args.get("-n");
        Map<String, Predicate<Path>> predicateMap = Map.of(
                "-m" , element -> element.getFileName().toString().matches(key.replace("*", "(.*)")),
                "-f", element -> element.getFileName().toString().equalsIgnoreCase(key),
                "-r", element -> element.getFileName().toString().matches(key));
        for (String keyPredicate : predicateMap.keySet()) {
            if (this.args.containsKey(keyPredicate)) {
                result = predicateMap.get(keyPredicate);
            }
        }
        return result;
    }
}
