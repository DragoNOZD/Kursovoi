package ru.mmo.database.item.weapon.ranged.projectile;

import ru.mmo.database.item.Item;
import ru.mmo.database.item.weapon.ranged.Ranged;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Projectile extends Item {

    @Column
    private float damage;

    @Enumerated(EnumType.STRING)
    @Column
    private ProjectileType type;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ranged_projectiles",
            joinColumns = { @JoinColumn(name = "ranged") }
    )
    @MapKeyJoinColumn(name = "projectile")
    @Column(name = "IsEquipped")
    private Map<Ranged, Boolean> weapons;

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

    public Map<Ranged, Boolean> getWeapons() {
        return weapons;
    }

    public void setWeapons(Map<Ranged, Boolean> weapons) {
        this.weapons = weapons;
    }
}
