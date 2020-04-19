package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {

    private UserStore<Base> userStore = new UserStore<>(2);

    @Before
    public void start() {
        this.userStore.add(new User("10", "Kirill", 25));
        this.userStore.add(new User("20", "Petr", 35));
    }

    @Test
    public void whenGetFirstIndex() {
        assertThat(((User) this.userStore.findById("10")).getName(), is("Kirill"));
    }

    @Test
    public void whenRemoveLastIndex() {
        this.userStore.delete("20");
        assertThat(((User) this.userStore.findById("10")).getName(), is("Kirill"));
    }

    @Test
    public void whenReplaceFirstIndex() {
        this.userStore.replace("10", new User("30", "Ivan", 45));
        assertThat(((User) this.userStore.findById("30")).getName(), is("Ivan"));
        assertThat(((User) this.userStore.findById("20")).getName(), is("Petr"));
    }
}
