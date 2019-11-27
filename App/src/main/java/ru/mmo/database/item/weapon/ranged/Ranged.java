package ru.mmo.database.item.weapon.ranged;

import ru.mmo.database.item.weapon.Weapon;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.ranged.device.Device;
import ru.mmo.database.item.weapon.ranged.projectile.Projectile;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Ranged extends Weapon {

    @ElementCollection
    @CollectionTable(name = "ranged_projectiles",
            joinColumns = { @JoinColumn(name = "ranged") }
    )
    @MapKeyJoinColumn(name = "projectile")
    @Column(name = "IsEquipped")
    private Map<Projectile, Boolean> projectiles;

    @ElementCollection
    @CollectionTable(name = "ranged_devices",
        joinColumns = { @JoinColumn(name = "ranged") }
    )
    @MapKeyJoinColumn(name = "device")
    @Column(name = "IsEquipped")
    private Map<Device, Boolean> devices;

    @Column
    private double projectileStartSpeed;

    @Column
    private int maxMagazineCount;

    @Transient
    private int magazineCount;

    @Column
    private String recoilCurve;

    public Ranged(String name, WeaponMount pos) {
        super(name, pos);
    }

    public Ranged() {
    }

    public Map<Projectile, Boolean> getProjectiles() {
        return projectiles;
    }

    public void setProjectiles(Map<Projectile, Boolean> projectiles) {
        this.projectiles = projectiles;
    }

    public Map<Device, Boolean> getDevices() {
        return devices;
    }

    public void setDevices(Map<Device, Boolean> devices) {
        this.devices = devices;
    }

    public double getProjectileStartSpeed() {
        return projectileStartSpeed;
    }

    public void setProjectileStartSpeed(double projectileStartSpeed) {
        this.projectileStartSpeed = projectileStartSpeed;
    }

    public int getMaxMagazineCount() {
        return maxMagazineCount;
    }

    public void setMaxMagazineCount(int maxMagazineCount) {
        this.maxMagazineCount = maxMagazineCount;
    }

    public int getMagazineCount() {
        return magazineCount;
    }

    public void setMagazineCount(int magazineCount) {
        this.magazineCount = magazineCount;
    }

    public String getRecoilCurve() {
        return recoilCurve;
    }

    public void setRecoilCurve(String recoilCurve) {
        this.recoilCurve = recoilCurve;
    }
}
