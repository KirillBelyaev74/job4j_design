package ru.job4j.isp;

import org.junit.Test;
import java.util.Optional;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AddItemTest {

    private final Menu first = new Menu("1", "Добавить");
    private final Menu second = new Menu("2", "Изменить");
    private final Menu third = new Menu("2.1", "Изменить пунк меню");
    private final Menu fourth = new Menu("2.2", "Изменить название");
    private final Menu fifth = new Menu("3", "Удалить");

    @Test
    public void when() {
        Item<Menu> item = new AddItem<>();
        item.addParent(this.first);
        item.addParent(this.second);
        item.addChild(this.second, this.third);
        item.addChild(this.second, this.fourth);
        item.addParent(this.fifth);
        Optional<Item.Node<Menu>> result = item.findBy(this.fifth);
        item.printMenu();
        assertThat(result.isPresent(), is(true));
    }
}
