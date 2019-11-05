package ru.mmo.database.item.weapon.melee;

import ru.mmo.database.item.weapon.melee.combo.Combo;
import ru.mmo.database.item.weapon.Weapon;

import javax.persistence.*;
import java.util.List;

@Entity
public class Melee extends Weapon {

    @OneToMany
    protected List<Combo> comboList;

    @Transient
    protected float damage;

    public Melee(String name, String pos) {
        super(name, pos);
    }

    public List<Combo> getComboList() {
        return comboList;
    }

    public void setComboList(List<Combo> comboList) {
        this.comboList = comboList;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }
}
