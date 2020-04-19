package ru.job4j.generic;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoleStoreTest {

    private RoleStore<Role> roleStore = new RoleStore<>(2);

    @Before
    public void start() {
        this.roleStore.add(new Role("10", "Hulk", "Marvel"));
        this.roleStore.add(new Role("20", "Super-Man", "DC"));
    }

    @Test
    public void whenGetFirstIndex() {
        assertThat(((Role) this.roleStore.findById("10")).getFilm(), is("Marvel"));
    }

    @Test
    public void whenRemoveLastIndex() {
        this.roleStore.delete("10");
        assertThat(((Role) this.roleStore.findById("20")).getFilm(), is("DC"));
        Assert.assertNull(this.roleStore.findById("10"));
    }

    @Test
    public void whenReplaceFirstIndex() {
        roleStore.replace("20", new Role("20", "Rapunciy", "Disney"));
        assertThat(((Role) this.roleStore.findById("10")).getFilm(), is("Marvel"));
        assertThat(((Role) this.roleStore.findById("20")).getFilm(), is("Disney"));
    }
}
