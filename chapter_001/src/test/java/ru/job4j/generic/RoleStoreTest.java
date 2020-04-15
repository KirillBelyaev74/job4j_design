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
        this.roleStore.add(new Role("0", "Hulk", "Marvel"));
        this.roleStore.add(new Role("1", "Super-Man", "DC"));
    }

    @Test
    public void whenGetFirstIndex() {
        assertThat(((Role) this.roleStore.findById("0")).getFilm(), is("Marvel"));
    }

    @Test
    public void whenRemoveLastIndex() {
        this.roleStore.delete("0");
        assertThat(((Role) this.roleStore.findById("0")).getFilm(), is("DC"));
        Assert.assertNull(this.roleStore.findById("1"));
    }

    @Test
    public void whenReplaceFirstIndex() {
        roleStore.replace("1", new Role("1", "Rapunciy", "Disney"));
        assertThat(((Role) this.roleStore.findById("0")).getFilm(), is("Marvel"));
        assertThat(((Role) this.roleStore.findById("1")).getFilm(), is("Disney"));
    }
}
