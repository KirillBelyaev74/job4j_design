package ru.job4j.tdd.cinema;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import ru.job4j.tdd.cinema.*;

import java.util.*;

public class CinemaTest {

    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void accountTicket() {
        Account account = new AccountCinema();
        account.addTicket(new Ticket3D());
        Ticket ticket =  account.getTicket(new AccountCinema());
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void freeSpace() {
        Session session = new Session3D();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 10, 10, 23, 00);
        Map<Integer, Integer> space = session.freeSpace(calendar);
        assertThat(space, is(Map.of()));
    }

    @Test
    public void buzySpace() {
        Session session = new Session3D();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 10, 10, 23, 00);
        Map<Integer, Integer> space = session.freeSpace(calendar);
        assertThat(space, is(Map.of()));
    }
}
