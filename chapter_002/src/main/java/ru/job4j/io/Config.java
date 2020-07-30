package ru.job4j.io;
import java.io.*;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int index = line.replaceAll("\\\\s*(#[a-zA-Z1-9]*)", "").indexOf("=");
                this.values.put(line.substring(0,index), line.substring(index + 1));
            }
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
