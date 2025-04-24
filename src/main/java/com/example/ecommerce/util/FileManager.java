package com.example.ecommerce.util;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String USER_FILE = "users.dat";

    // Save a single user (append to list)
    public static void saveUser(User user) {
        List<User> users = loadUsers();
        users.add(user);
        saveUsers(users);
    }

    // Load all users from file
    public static List<User> loadUsers() {
        File file = new File(USER_FILE);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // Save all users to file
    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Order> loadAllOrders() {
        try (Reader reader = new FileReader("orders.json")) {
            Type listType = new TypeToken<List<Order>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }


    // Check if username already exists
    public static boolean userExists(String username) {
        return loadUsers().stream().anyMatch(u -> u.getUsername().equals(username));
    }
}