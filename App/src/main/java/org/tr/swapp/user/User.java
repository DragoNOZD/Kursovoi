package org.tr.swapp.user;

import org.tr.swapp.Country;
import org.tr.swapp.game.Game;

import javax.persistence.*;
import java.net.URL;
import java.util.List;

@Entity
@Table(name = "User_entity")
public class User {
    @Id
    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    //@Column
    //private String email;

    //@Column
    //private Calendar registrationDate;

    @Column
    @OneToMany
    private List<Game> library;

    @Column
    @OneToMany
    private List<User> friends;

    @Column
    private URL image;

    @Enumerated(EnumType.STRING)
    @Column
    private Country country = Country.NOT_SELECTED;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
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

    public List<Game> getLibrary() {
        return library;
    }

    public void addGamesToLibrary(Game game) {
        this.library.add(game);
    }

    public void addGamesToLibrary(List<Game> games) {
        this.library.addAll(games);
    }

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addFriends(User friend) {
        friends.add(friend);
    }

    public void addFriends(List<User> friends) {
        this.friends.addAll(friends);
    }
}
