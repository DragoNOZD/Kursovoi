package ru.mmo.database.ranged;

import ru.mmo.database.projectile.Projectile;
import ru.mmo.database.weapon.Weapon;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ranged extends Weapon {

    @ManyToOne
    protected Projectile projectile;

    public Ranged(String name, String pos) {
        super(name, pos);
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }
}
