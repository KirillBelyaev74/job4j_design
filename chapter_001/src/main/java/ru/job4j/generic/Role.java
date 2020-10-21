package ru.job4j.generic;

import java.util.Objects;

public class Role extends Base {

    private String role;
    private String film;

    protected Role(String id, String role, String film) {
        super(id);
        this.role = role;
        this.film = film;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role) && Objects.equals(film, role1.film);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, film);
    }

    @Override
    public String toString() {
        return "Role{" + "role='" + role + '\'' + ", film='" + film + '\'' + '}';
    }
}
