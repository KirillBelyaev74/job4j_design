package ru.job4j.reference;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import java.io.IOException;
import java.lang.ref.SoftReference;

public class LoadFileTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenNameFileThenNames() throws IOException {
        LoadFile loadFile = new LoadFile();
        String expect = "Kirill Belyaev" + System.lineSeparator() + "Petr Arsentiev";
        assertThat(loadFile.textOfFile("names.txt").get(), is(new SoftReference<>(expect).get()));
    }

    @Test
    public void whenNameFileThenAddress() throws IOException {
        LoadFile loadFile = new LoadFile();
        String expect = "Russia" + System.lineSeparator() + "USA";
        assertThat(loadFile.textOfFile("address.txt").get(), is(new SoftReference<>(expect).get()));
    }

    @Test
    public void whenNameFileThenNamesAndAddress() throws IOException {
        LoadFile loadFile = new LoadFile();
        loadFile.textOfFile("names.txt");
        loadFile.textOfFile("address.txt");
        String expectNames = "Kirill Belyaev" + System.lineSeparator() + "Petr Arsentiev";
        String expectAddress = "Russia" + System.lineSeparator() + "USA";
        assertThat(loadFile.textOfFile("names.txt").get(), is(new SoftReference<>(expectNames).get()));
        assertThat(loadFile.textOfFile("address.txt").get(), is(new SoftReference<>(expectAddress).get()));
    }
}