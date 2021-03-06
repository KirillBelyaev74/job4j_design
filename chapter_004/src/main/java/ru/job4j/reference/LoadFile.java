package ru.job4j.reference;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.*;

public class LoadFile {

    private final Map<String, SoftReference<String>> hashMap = new HashMap<>();

    public String textOfFile(String fileName) throws IOException {
        if (fileName == null) {
            throw new NullPointerException();
        }
        String result = this.hashMap.get(fileName).get();
        if (result == null) {
            result = this.readFile(fileName).get();
        }
        return result;
    }

    public SoftReference<String> readFile(String fileName) throws IOException {
        byte[] result = null;
        try (InputStream inputStream = LoadFile.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
                    result = bufferedInputStream.readAllBytes();
                }
            }
        }
        if (result == null) {
            throw new NullPointerException();
        }
        SoftReference<String> softReference = new SoftReference<>(new String(result));
        this.hashMap.put(fileName, softReference);
        return softReference;
    }
}
