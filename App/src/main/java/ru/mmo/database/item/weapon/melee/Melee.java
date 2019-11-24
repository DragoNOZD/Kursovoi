package ru.mmo.database.item.weapon.melee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.melee.combo.Combo;
import ru.mmo.database.item.weapon.Weapon;

import javax.persistence.*;
import java.util.List;

@Entity
@Configurable
public class Melee extends Weapon {

    @Autowired
    @Transient
    private MeleeService service;

    @OneToMany(mappedBy = "weapon")
    protected List<Combo> comboList;

    @Transient
    protected float damage;

    public Melee(String name, WeaponMount pos) {
        super(name, pos);
        service.addMelee(this);
    }

    public Melee() {
    }

    private void updateMelee(){
        service.updateMelee(this);
    }

    public List<Combo> getComboList() {
        return comboList;
    }

    public void setComboList(List<Combo> comboList) {
        this.comboList = comboList;
        updateMelee();
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public MeleeService getService() {
        return service;
    }

    public void setService(MeleeService service) {
        this.service = service;
    }
}
