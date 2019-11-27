package ru.mmo.database.item.weapon;

import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Weapon extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    protected WeaponMount mount;

    @Column
    protected String takeAnimation;

    @Column
    protected String putAnimation;

    public Weapon(String name, WeaponMount mount) {
        super(name);
        this.mount = mount;
    }

    public Weapon() {
    }

    public WeaponMount getMount() {
        return mount;
    }

    public void setMount(WeaponMount mount) {
        this.mount = mount;
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
