package ru.job4j.io;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import java.io.*;
import java.util.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void drop() throws IOException {
        File source = folder.newFile("with_errors.csv");
        File target = folder.newFile("without_errors.csv");
        List<String> list = List.of(
                "200 10:56:01\n",
                "500 10:57:01\n",
                "400 10:58:01\n",
                "200 10:59:01\n",
                "500 11:01:02\n",
                "200 11:02:02");
        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(source)))) {
            list.forEach(printWriter::write);
        }
        new Analizy().findMistakes(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> result = new LinkedList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = in.readLine()) != null) {
                result.add(line + "\n");
            }
        }
        assertThat(result.contains("10:57:01\n"), is(true));
        assertThat(result.contains("10:59:01\n"), is(true));
        assertThat(result.contains("11:01:02\n"), is(true));
        assertThat(result.contains("11:02:02\n"), is(true));
    }
}
