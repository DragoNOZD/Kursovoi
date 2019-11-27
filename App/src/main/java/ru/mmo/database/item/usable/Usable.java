package ru.mmo.database.item.usable;

import ru.mmo.database.actor.Actor;
import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Usable extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    protected UsableItemType item;

    public Usable(String name, UsableItemType item) {
        super(name);
        this.item = item;
    }

    public UsableItemType getItem() {
        return item;
    }

    public void setItem(UsableItemType item) {
        this.item = item;
    }

    public void use(Actor actor){

    }
}
