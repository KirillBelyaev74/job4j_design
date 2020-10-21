package ru.job4j.jdbc;

import java.io.*;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class ImportDB {

    private String dump;
    private Connection connection;

    public ImportDB(String dump) {
        this.dump = dump;
    }

    public void setConnection() throws SQLException {
        try (InputStream inputStream = ImportDB.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    properties.getProperty("host"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dump))) {
            String result;
            while ((result = bufferedReader.readLine()) != null) {
                int index = result.indexOf(";");
                users.add(new User(result.substring(0, index), result.substring(index + 1)));
            }
        }
        return users;
    }

    public void createDB() {
        try (Statement statement = this.connection.createStatement()) {
            statement.execute("create table if not exists spam(" +
                    "id serial primary key not null," +
                    "name varchar(50) not null," +
                    "email varchar(50) not null unique)");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void save(List<User> users) {
        for (User user : users) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("insert into spam(name, email) values (?, ?)")) {
                preparedStatement.setString(1, user.name);
                preparedStatement.setString(2, user.email);
                preparedStatement.execute();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

    }

    public static void main(String[] args) throws Exception {
        ImportDB db = new ImportDB("./chapter_003/data/dump.txt");
        db.setConnection();
        db.createDB();
        db.save(db.load());
    }
}