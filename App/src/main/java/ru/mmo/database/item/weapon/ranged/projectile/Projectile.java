package ru.mmo.database.item.weapon.ranged.projectile;

import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
public class Projectile extends Item {

    @Column
    private float damage;

    @Enumerated(EnumType.STRING)
    @Column
    private ProjectileType type;

    public Projectile(String name, float damage, ProjectileType type) {
        super(name);
        this.damage = damage;
        this.type = type;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public ProjectileType getType() {
        return type;
    }

    public void setType(ProjectileType type) {
        this.type = type;
    }
}
