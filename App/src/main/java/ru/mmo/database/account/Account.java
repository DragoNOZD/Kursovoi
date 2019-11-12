package ru.mmo.database.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Account_entity")
@Configurable
public class Account {

    @Autowired
    @Transient
    private AccountService service;

    @Id
    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @ManyToMany
    private List<Account> friends;

    @Column
    private String image;

    @Enumerated(EnumType.STRING)
    @Column
    private Country country = Country.NOT_SELECTED;

    public Account() {
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
        service.addUser(this);
    }

    private void editAccount(){
        service.editUser(this);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        editAccount();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        editAccount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        editAccount();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        editAccount();
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
        editAccount();
    }

    public void setFriends(List<Account> friends) {
        this.friends = friends;
        editAccount();
    }

    public List<Account> getFriends() {
        return friends;
    }

    public void addFriends(Account friend) {
        friends.add(friend);
        editAccount();
    }

    public void addFriends(List<Account> friends) {
        this.friends.addAll(friends);
        editAccount();
    }

    public AccountService getService() {
        return service;
    }

    public void setService(AccountService service) {
        this.service = service;
    }
}
