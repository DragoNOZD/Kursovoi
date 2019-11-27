package ru.mmo.database.account;

import org.springframework.beans.factory.annotation.Configurable;
import ru.mmo.database.actor.playable.PlayableActor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Account")
@Configurable
public class Account {

    @Id
    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column
    private String name = "";

    @ManyToMany
    private List<Account> friends;

    @Column
    private String image = "";

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private Country country = Country.NOT_SELECTED;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<PlayableActor> actors;

    public Account() {
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setFriends(List<Account> friends) {
        this.friends = friends;
    }

    public List<Account> getFriends() {
        return friends;
    }

    public void addFriends(Account friend) {
        friends.add(friend);
    }

    public void addFriends(List<Account> friends) {
        this.friends.addAll(friends);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<PlayableActor> getActors() {
        return actors;
    }

    public void setActors(List<PlayableActor> actors) {
        this.actors = actors;
    }
}
