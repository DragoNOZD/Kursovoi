package ru.mmo.database.item.weapon.ranged;

import ru.mmo.database.item.weapon.Weapon;
import ru.mmo.database.item.weapon.WeaponPosition;
import ru.mmo.database.item.weapon.ranged.device.Device;
import ru.mmo.database.item.weapon.ranged.projectile.Projectile;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Ranged extends Weapon {

    @ManyToOne
    protected Projectile projectile;

    @ElementCollection
    @CollectionTable(name = "ranged_devices",
        joinColumns = { @JoinColumn(name = "ranged") }
    )
    @MapKeyJoinColumn(name = "device")
    @Column(name = "IsEquipped")
    protected Map<Device, Boolean> devices;

    public Ranged(String name, WeaponPosition pos) {
        super(name, pos);
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    public Map<Device, Boolean> getDevices() {
        return devices;
    }

    public void setDevices(Map<Device, Boolean> devices) {
        this.devices = devices;
    }
}
