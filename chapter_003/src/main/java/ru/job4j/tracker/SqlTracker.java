package ru.job4j.tracker;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class SqlTracker implements Store {

    private Connection connection;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("db.host"),
                    config.getProperty("db.login"),
                    config.getProperty("db.password"));
            this.createTable();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            statement.execute(
                    "create table if not exists items(id serial primary key, name varchar(20) not null)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "insert into item(name) values (initcap(?));", Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                new Item(String.valueOf(resultSet.getInt("id")), resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        ResultSet resultSet = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "update item set name = initcap(?) where item_id = ?;")) {
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, Integer.parseInt(id));
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet == null;
    }

    @Override
    public boolean delete(String id) {
        int result = -1;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "delete from item where id = ?;")) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result == 1;
    }

    @Override
    public List<Item> findAll() {
        List<Item> list = new LinkedList<>();
        try (Statement statement = this.connection.createStatement()) {
            statement.executeQuery("select * from item;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                list.add(new Item(
                        String.valueOf(resultSet.getInt("id")),
                        resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> list = new LinkedList<>();
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "select * from item where name = ?;")) {
            preparedStatement.setString(1, key);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                list.add(new Item(
                        String.valueOf(resultSet.getInt("id")),
                        resultSet.getString("name")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "select * from item where id = ?;")) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                item = new Item(
                        String.valueOf(resultSet.getInt("id")),
                        resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }
}