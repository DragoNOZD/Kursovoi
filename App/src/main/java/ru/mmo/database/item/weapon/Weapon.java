package ru.mmo.database.item.weapon;

import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Weapon extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    protected WeaponMount pos;

    @Column
    protected String takeAnimation;

    @Column
    protected String putAnimation;

    public Weapon(String name, WeaponMount pos) {
        super(name);
        this.pos = pos;
    }

    public WeaponMount getPos() {
        return pos;
    }

    public void setPos(WeaponMount pos) {
        this.pos = pos;
    }

    public String getTakeAnimation() {
        return takeAnimation;
    }

    public void setTakeAnimation(String takeAnimation) {
        this.takeAnimation = takeAnimation;
    }

    public String getPutAnimation() {
        return putAnimation;
    }

    public void setPutAnimation(String putAnimation) {
        this.putAnimation = putAnimation;
    }
}
