package ru.mmo.database.account;

import java.util.List;

public interface AccountService {
    void addUser(Account account);
    void editUser(Account account);
    void deleteUser(String login);
    Account getByLogin(String login);
    List<Account> getAll();
    List<Account> getAllByCountry(Country country);
    List<Account> getAllByName(String name);
    Account getByEmail(String email);
    List<Account> getAllLimited(int from, int to);
    Long getEntitiesCount();
}
