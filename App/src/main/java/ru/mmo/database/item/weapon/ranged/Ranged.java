package ru.mmo.database.item.weapon.ranged;

import ru.mmo.database.item.weapon.WeaponPosition;
import ru.mmo.database.item.weapon.ranged.projectile.Projectile;
import ru.mmo.database.item.weapon.Weapon;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ranged extends Weapon {

    @ManyToOne
    protected Projectile projectile;

    public Ranged(String name, WeaponPosition pos) {
        super(name, pos);
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }
}
