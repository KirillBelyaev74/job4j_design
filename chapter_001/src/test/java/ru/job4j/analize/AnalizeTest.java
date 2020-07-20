package ru.job4j.analize;
import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizeTest {

    @Test
    public void whenAddedFiveUsersThenChangedTwoUsersAndDeleteOne() {

        Analize analize = new Analize();

        Analize.User kirill = new Analize.User(10, "Kirill");
        Analize.User kostya = new Analize.User(20, "Kostya");
        Analize.User ivan = new Analize.User(30, "Ivan");
        Analize.User petr = new Analize.User(40, "Petr");
        Analize.User maxim = new Analize.User(50, "Maxim");

        List<Analize.User> previous = List.of(kirill, kostya, ivan, petr, maxim);

        List<Analize.User> current = List.of(
                ivan,
                kostya,
                new Analize.User(100, "Maxim"),
                new Analize.User(200, "Sergey"));

        Analize.Info result = analize.diff(previous, current);

        Analize.Info info = new Analize.Info(2, 1,2);

        assertThat(info, is(result));
    }
}
