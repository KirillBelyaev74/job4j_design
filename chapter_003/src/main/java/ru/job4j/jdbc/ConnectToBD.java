package ru.job4j.jdbc;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectToBD {
    public static void main(String[] args) {
        Properties property = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C:\\project\\job4j_design\\chapter_003\\src\\main\\resources\\config.properties");
            property.load(fis);
            String host = property.getProperty("db.host");
            String login = property.getProperty("db.login");
            String password = property.getProperty("db.password");
            System.out.println("HOST: " + host + ", LOGIN: " + login + ", PASSWORD: " + password);
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
}
