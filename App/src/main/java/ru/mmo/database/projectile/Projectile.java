package ru.mmo.database.projectile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Projectile {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @Column
    private float damage;

    @Column
    private ProjectileType type;

    public Projectile(String name, float damage, ProjectileType type) {
        this.name = name;
        this.damage = damage;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
