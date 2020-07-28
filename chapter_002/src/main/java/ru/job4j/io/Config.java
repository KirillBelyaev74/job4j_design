package ru.job4j.io;
import java.io.*;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();
    private List<String> lines = new ArrayList<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path))) {
            bufferedReader.lines().forEach(s -> this.values.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=") + 1)));
        } catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
    }

    public String value(String key) {
        return this.values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
