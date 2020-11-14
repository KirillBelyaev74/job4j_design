package ru.job4j.reference;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.*;

public class LoadFile {

    private Map<SoftReference<String>, String> hashMap = new HashMap<>();

    public String textOfFile (String fileName) throws IOException {
        if (fileName == null) {
            throw new NullPointerException();
        }
        SoftReference<String> softReference = new SoftReference<>(fileName);
        while ((this.hashMap.get(softReference)) == null) {
            this.readFile(softReference);
        }
        return this.hashMap.get(softReference);
    }

    public void readFile (SoftReference<String> fileName) throws IOException {
        byte[] result = null;
        try (InputStream inputStream = LoadFile.class.getClassLoader().getResourceAsStream(fileName.get())) {
            if (inputStream != null) {
                try (BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
                    result = bufferedInputStream.readAllBytes();
                }
            }
        }
        this.hashMap.put(fileName, new String(Objects.requireNonNull(result)));
    }
}
