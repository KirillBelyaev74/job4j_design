package ru.job4j.serialization;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class POJOToFile {

    public void stringToJSON(String user) {
        JSONObject jsonObject = new JSONObject("{" + user + "}");
        System.out.println(jsonObject.toString());
    }

    public void arraylistToJSON(String user) {
        List<String> list = new ArrayList<>();
        list.add(user);
        list.forEach(System.out::println);
    }

    public void objectsToJSON(User user) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", user.getName());
        jsonObject.put("age", user.getAge());
        jsonObject.put("birthday", user.getBirthday());
        System.out.println(jsonObject.toString());
    }

    public static void main(String[] args) {
        POJOToFile pojoToFile = new POJOToFile();
        User user = new User("Kirill", new GregorianCalendar(1994, 9, 17), true, 26);
        pojoToFile.stringToJSON(user.toString());
        pojoToFile.arraylistToJSON(user.toString());
        pojoToFile.objectsToJSON(user);
    }
}
