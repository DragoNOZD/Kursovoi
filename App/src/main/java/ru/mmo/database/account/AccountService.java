package ru.mmo.database.account;

import java.util.List;

public interface AccountService {
    void addUser(Account account);
    void editUser(Account account);
    void deleteUser(String login);
    Account getByLogin(String login);
    List<Account> getAll();
    boolean checkPassword(String login, String password);
}
