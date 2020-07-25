package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EvenNumberFile {

    public void fileTo() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("even.txt")) {
            int read;
            while ((read = fileInputStream.read()) != -1) {
                if (read % 2 == 0) {
                    System.out.print(String.valueOf((char) read).trim());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new EvenNumberFile().fileTo();
    }
}
