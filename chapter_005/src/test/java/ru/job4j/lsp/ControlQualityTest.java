package ru.job4j.lsp;

import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenDiscountOnPrice() {
        Food milk = new Food(
                "Milk",
                new GregorianCalendar(2020, 10, 25),
                new GregorianCalendar(2020, 11, 2),
                50, 10);

        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);

        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.distribution(milk);
        assertThat(shop.clear().get(0).getPrice(), is(45D));
    }

    @Test
    public void whenFoodExpiredStoragePeriod() {
        Food cheese = new Food(
                "Cheese",
                new GregorianCalendar(2020, 10, 20),
                new GregorianCalendar(2020, 10, 29),
                100, 20);

        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);

        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.distribution(cheese);
        assertNotNull(trash.clear());
    }

    @Test
    public void whenFoodForShop() {
        Food chocolate = new Food(
            "Cheese",
            new GregorianCalendar(2020, 10, 25),
            new GregorianCalendar(2020, 11, 5),
            70, 10);

        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);

        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.distribution(chocolate);
        assertNotNull(shop.clear());
    }

    @Test
    public void whenFoodForShopAndResort() {
        Food chocolate = new Food(
                "Chocolate",
                new GregorianCalendar(2020, 11, 1),
                new GregorianCalendar(2020, 11, 10),
                70, 10);

        Storage warehouse = new Warehouse();
        Storage shop = new Shop();
        Storage trash = new Trash();
        List<Storage> storages = List.of(warehouse, shop, trash);

        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.distribution(chocolate);
        controlQuality.resort();
        assertNotNull(shop.clear());
    }
}
