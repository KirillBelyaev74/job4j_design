package ru.job4j.io;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) throws IOException {
        List<String> listResult = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source))) {
            bufferedReader.lines().forEach(listResult::add);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        this.recordMistake(this.searchMistake(listResult), target);
    }

    public List<String> searchMistake(List<String> listWithMistake) {
        int index = 0;
        while (index != listWithMistake.size()) {
            String line = listWithMistake.get(index);
            if (!line.contains("400") && !line.contains("500") && index == 0) {
                listWithMistake.remove(index);
            } else if ((line.contains("400") || line.contains("500")) &&
                    (listWithMistake.get(index + 1).contains("400") || listWithMistake.get(index + 1).contains("500"))) {
                listWithMistake.remove(index + 1);
            } else {
                index++;
            }
        }
        return listWithMistake;
    }

    public void recordMistake(List<String> mistake, String target) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            mistake.forEach(s -> printWriter.write(s + "\r"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Analizy().unavailable("with_errors.csv", "without_errors.csv");
    }
}