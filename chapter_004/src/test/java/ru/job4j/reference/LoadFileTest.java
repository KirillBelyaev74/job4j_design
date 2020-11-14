package ru.job4j.reference;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import java.io.IOException;

public class LoadFileTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenNameFileThenNames() throws IOException {
        LoadFile loadFile = new LoadFile();
        assertThat(loadFile.textOfFile("names.txt"), is("Kirill Belyaev" + System.lineSeparator() + "Petr Arsentiev"));
    }

    @Test
    public void whenNameFileThenAddress() throws IOException {
        LoadFile loadFile = new LoadFile();
        assertThat(loadFile.textOfFile("address.txt"), is("Russia" + System.lineSeparator() + "USA"));
    }

    @Test
    public void whenNameFileThenNamesAndAddress() throws IOException {
        LoadFile loadFile = new LoadFile();
        loadFile.textOfFile("names.txt");
        loadFile.textOfFile("address.txt");
        assertThat(loadFile.textOfFile("names.txt"), is("Kirill Belyaev" + System.lineSeparator() + "Petr Arsentiev"));
        assertThat(loadFile.textOfFile("address.txt"), is("Russia" + System.lineSeparator() + "USA"));
    }
}