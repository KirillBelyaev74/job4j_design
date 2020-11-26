package ru.job4j.tdd;

import org.junit.Test;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GeneratorStringTest {

    private final String template = "I am a ${name}, Who are ${subject}?";

    @Test
    public void whenTemplateThenString() {
        Generator generator = new GeneratorString();
        Map<String, String> args = Map.of("name", "Kirill Belyaev", "subject", "you");
        String result = generator.produce(this.template, args);
        assertThat(result, is("I am a Kirill Belyaev, Who are you?"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateThenNullPointerException() {
        Generator generator = new GeneratorString();
        Map<String, String> args = Map.of("surname", "Kirill Belyaev", "object", "you");
        String result = generator.produce(this.template, args);
        assertThat(result, is(args));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenTemplateThenIllegalArgumentException() {
        Generator generator = new GeneratorString();
        Map<String, String> args = Map.of(
                "name", "Kirill Belyaev", "subject", "you",
                "surname", "Kirill Belyaev", "object", "you");
        String result = generator.produce(this.template, args);
        assertThat(result, is(args));
    }
}