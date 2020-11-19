package ru.job4j.tdd;

public interface Account {

    Ticket getTicket(Account account);
    void addTicket(Ticket ticket);
}
