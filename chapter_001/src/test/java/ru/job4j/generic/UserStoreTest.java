package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {

    private UserStore<Base> userStore = new UserStore<>(2);

    @Before
    public void start() {
        this.userStore.add(new User("0", "Kirill", 25));
        this.userStore.add(new User("1", "Petr", 35));
    }

    @Test
    public void whenGetFirstIndex() {
        assertThat(((User) this.userStore.findById("0")).getName(), is("Kirill"));
    }

    @Test
    public void whenRemoveLastIndex() {
        this.userStore.delete("1");
        assertThat(((User) this.userStore.findById("0")).getName(), is("Kirill"));
    }

    @Test
    public void whenReplaceFirstIndex() {
        this.userStore.replace("0", new User("0", "Ivan", 45));
        assertThat(((User) this.userStore.findById("0")).getName(), is("Ivan"));
        assertThat(((User) this.userStore.findById("1")).getName(), is("Petr"));
    }
}
