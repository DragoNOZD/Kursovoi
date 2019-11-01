package ru.mmo.database.item.weapon;

import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Weapon extends Item {

    @Column
    protected String pos;

    public Weapon(String name, String pos) {
        super(name);
        this.pos = pos;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
