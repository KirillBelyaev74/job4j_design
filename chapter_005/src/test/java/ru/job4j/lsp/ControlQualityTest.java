package ru.job4j.lsp;

import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    private final Calendar calendarOne = new GregorianCalendar(2020, 10, 20);
    private final Calendar calendarTwo = new GregorianCalendar(2020, 10, 30);
    private final Calendar calendarThree = new GregorianCalendar(2020, 10, 25);
    private final Place warehouse = new Warehouse();
    private final Place shop = new Shop();
    private final Place trash = new Trash();

    @Test
    public void whenDiscountOnPrice() {
        Food milk = new Food("Milk", calendarOne, calendarTwo, 50, 10);
        ControlQuality controlQuality = new ControlQuality(this.warehouse, this.shop, this.trash);
        controlQuality.distribution(milk);
        double result = this.shop.getFoods().get(0).getPrice();
        assertThat(result, is(45D));
    }

    @Test
    public void whenFoodExpiredStoragePeriod() {
        Food cheese = new Food("Cheese", calendarOne, calendarThree, 100, 20);
        ControlQuality controlQuality = new ControlQuality(this.warehouse, this.shop, this.trash);
        controlQuality.distribution(cheese);
        assertNotNull(this.trash.getFoods());
    }

    @Test
    public void whenFoodForShop() {
        Food chocolate = new Food("Chocolate", calendarTwo, calendarThree, 100, 15);
        ControlQuality controlQuality = new ControlQuality(this.warehouse, this.shop, this.trash);
        controlQuality.distribution(chocolate);
        assertNotNull(this.shop.getFoods());
    }
}
