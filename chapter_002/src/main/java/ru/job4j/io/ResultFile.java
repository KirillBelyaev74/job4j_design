package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {

    public void fileOut() {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int left = 1; left != 10; left++) {
                for (int right = 1; right != 10; right++) {
                    out.write(Integer.toString((left * right)).getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.getProperty("line.separator").getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ResultFile().fileOut();
    }
}
