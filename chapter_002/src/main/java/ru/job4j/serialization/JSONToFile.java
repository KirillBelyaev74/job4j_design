package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.GregorianCalendar;

public class JSONToFile {

    public void writeFile(User user) {
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(user));
    }

    public static void main(String[] args) {
        new JSONToFile().writeFile(new User(
                "Kirill", new GregorianCalendar(1994, 9, 17), true, 26));
    }
}
