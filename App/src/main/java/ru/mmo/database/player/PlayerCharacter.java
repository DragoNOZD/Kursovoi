package ru.mmo.database.player;

import ru.mmo.database.character.Character;
import ru.mmo.database.user.User;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PlayerCharacter extends Character {

    @ManyToOne
    protected User owner;

    public PlayerCharacter(String name, int maxHP, User owner) {
        super(name, maxHP);
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}
