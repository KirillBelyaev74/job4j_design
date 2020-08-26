package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path path : sources) {
                zipOutputStream.putNextEntry(new ZipEntry(path.toString()));
                Files.copy(path, zipOutputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        String directory = argZip.directory();
        MySimpleFileVisitor mySimpleFileVisitor = new MySimpleFileVisitor(argZip.exclude(), directory);
        Files.walkFileTree(Paths.get(directory), mySimpleFileVisitor);
        this.packFiles(mySimpleFileVisitor.getFiles(), new File(directory + argZip.output()));
    }

    public static void main(String[] args) throws IOException {
        new Zip().start(args);
    }
}