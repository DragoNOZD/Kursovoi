package ru.mmo.database.actor.playable;

import ru.mmo.database.actor.Actor;
import ru.mmo.database.account.Account;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PlayableActor extends Actor {

    @ManyToOne
    protected Account owner;

    public PlayableActor(String name, int maxHP, Account owner) {
        super(name, maxHP);
        this.owner = owner;
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }
}
