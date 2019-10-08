package org.tr.swapp.user;

import javax.persistence.*;

@Entity
@Table(name = "User_entity")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(unique=true, nullable = false, length = 20)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(length = 20)
    private String name;

    /*Library*/

    //@Column
    //private ArrayList<User> friends;

    /*Image*/

    /*Country*/

    /*Wishlist*/

    public User(String login, String password) {
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
