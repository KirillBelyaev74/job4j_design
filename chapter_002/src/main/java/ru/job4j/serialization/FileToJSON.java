package ru.job4j.serialization;

import com.google.gson.GsonBuilder;

public class FileToJSON {

    public void readFile(String file) {
        User user = new GsonBuilder().create().fromJson(file, User.class);
        System.out.println(user);
    }

    public static void main(String[] args) {
        new FileToJSON().readFile("{\"name\":\"Kirill\",\"birthday\":{\"year\":1994,\"month\":9,\"dayOfMonth\":17,\"hourOfDay\":0,\"minute\":0,\"second\":0},\"sexMan\":true,\"age\":26}");
    }
}
