package ru.job4j.map;
import org.junit.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class MapUserTest {

    @Test
    public void whenTwoUsersEqual() {
        MapUser mapUser = new MapUser();
        Calendar calendar = new GregorianCalendar(1994, Calendar.AUGUST, 17);
        mapUser.compareUser(new User("Kirill", 0, calendar));
        mapUser.compareUser(new User("Kirill", 0, calendar));
        for (User user : mapUser.getMap().keySet()) {
            System.out.println(user.getName());
        }
    }
}
