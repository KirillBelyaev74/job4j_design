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
        SoftReference<String> result;
        if (this.hashMap.containsKey(fileName)) {
             result = this.hashMap.get(fileName);
        } else {
            result = this.readFile(fileName);
        }
        return Objects.requireNonNull(result);
    }

    public SoftReference<String> readFile (String fileName) throws IOException {
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
