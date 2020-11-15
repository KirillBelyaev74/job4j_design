package ru.job4j.reference;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.*;

public class LoadFile {

    private final Map<String, SoftReference<String>> hashMap = new HashMap<>();

    public SoftReference<String> textOfFile (String fileName) throws IOException {
        if (fileName == null) {
            throw new NullPointerException();
        }
        SoftReference<String> result = this.hashMap.get(fileName);
        if (result == null) {
            this.readFile(fileName);
        }
        return this.hashMap.get(fileName);
    }

    public void readFile (String fileName) throws IOException {
        byte[] result = null;
        try (InputStream inputStream = LoadFile.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
                    result = bufferedInputStream.readAllBytes();
                }
            }
        }
        this.hashMap.put(fileName, new SoftReference<>(new String(result)));
    }
}
