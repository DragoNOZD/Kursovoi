package ru.trapeznikov.database.user;

import java.util.List;

public interface UserService {

    void addUser(User user);
    void editUser(User user);
    void deleteUser(String login);
    User getByLogin(String login);
    List<User> getAll();
    boolean checkPassword(String login, String password);
}
