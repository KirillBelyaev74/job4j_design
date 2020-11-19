package ru.job4j.tdd.cinema;

public interface Account {

    Ticket getTicket(Account account);
    void addTicket(Ticket ticket);
}
