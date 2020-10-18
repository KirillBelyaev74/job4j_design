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

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "insert into item(item_id, name) values (?, initcap(?));")) {
            preparedStatement.setInt(1, Integer.parseInt(item.getId()));
            preparedStatement.setString(2, item.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        int result = -1;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "update item set item_id = ?, name = initcap(?) where item_id = ?;")) {
            preparedStatement.setInt(1, Integer.parseInt(item.getId()));
            preparedStatement.setString(2, item.getName());
            preparedStatement.setInt(3, Integer.parseInt(id));
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result == 1;
    }

    @Override
    public boolean delete(String id) {
        int result = -1;
        try (PreparedStatement preparedStatement = this.connection.prepareStatement(
                "delete from item where item_id = ?;")) {
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
        try (ResultSet resultSet = this.connection.createStatement().executeQuery("select * from item;")) {
            while (resultSet.next()) {
                list.add(new Item(
                        String.valueOf(resultSet.getInt("item_id")),
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
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                list.add(new Item(
                        String.valueOf(resultSet.getInt("item_id")),
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
                "select * from item where item_id = ?;")) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                item = new Item(
                        String.valueOf(resultSet.getInt("item_id")),
                        resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }
}