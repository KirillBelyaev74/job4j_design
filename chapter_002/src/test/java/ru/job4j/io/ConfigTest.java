package ru.job4j.io;
import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() throws IOException {
        Config config = new Config("./data/pair_without_comment.properties");
        config.load();
        assertThat(
                config.value("name"),
                is("Kirill")
        );
    }
}