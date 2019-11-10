package ru.mmo.database.item.weapon;

import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Weapon extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    protected WeaponPosition pos;

    public Weapon(String name, WeaponPosition pos) {
        super(name);
        this.pos = pos;
    }

    public WeaponPosition getPos() {
        return pos;
    }

    public void setPos(WeaponPosition pos) {
        this.pos = pos;
    }
}
