package ru.job4j.tree;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);

        assertThat(
                tree.findBy(element -> element.value.equals(6)).isPresent(),
                is(true)
        );
    }

    @Test
    public void whenChild2ExistThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.add(1, 2),
                is(false)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(element -> element.value.equals(7)).isPresent(),
                is(false)
        );
    }

    @Test
    public void when3ElementAddThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 4);
        assertThat(tree.isBinary(), is(false));
    }

    @Test
    public void when1ElementAddThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        assertThat(tree.isBinary(), is(true));
    }
}
