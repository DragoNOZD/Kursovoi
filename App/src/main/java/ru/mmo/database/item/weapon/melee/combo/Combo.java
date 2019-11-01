package ru.mmo.database.item.weapon.melee.combo;

import ru.mmo.database.item.weapon.melee.Melee;

import javax.persistence.*;

@Entity
public class Combo {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Melee weapon;

    @Column
    private float damage;

    @Column
    private String sequence;

    public Combo(float damage, String sequence) {
        this.damage = damage;
        this.sequence = sequence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Melee getWeapon() {
        return weapon;
    }

    public void setWeapon(Melee weapon) {
        this.weapon = weapon;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
