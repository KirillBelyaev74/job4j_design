package ru.job4j.jdbc;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectToBD {
    public static void main(String[] args) {
        try (InputStream inputStream = ImportDB.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            System.out.println("HOST: " + url + ", LOGIN: " + username + ", PASSWORD: " + password);
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getUserName());
                System.out.println(metaData.getURL());
            }
        } catch (IOException | SQLException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }
}
