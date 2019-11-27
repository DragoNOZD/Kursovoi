package ru.mmo.database.item.weapon.melee;

import ru.mmo.database.item.weapon.Weapon;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.melee.combo.Combo;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Melee extends Weapon {

    @OneToMany(mappedBy = "weapon")
    protected List<Combo> comboList;

    @Transient
    protected float damage;

    public Melee(String name, WeaponMount pos) {
        super(name, pos);
    }

    public Melee() {
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
