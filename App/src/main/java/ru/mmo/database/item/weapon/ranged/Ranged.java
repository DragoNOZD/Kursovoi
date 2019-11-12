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
    protected Map<Projectile, Boolean> projectiles;

    @ElementCollection
    @CollectionTable(name = "ranged_devices",
        joinColumns = { @JoinColumn(name = "ranged") }
    )
    @MapKeyJoinColumn(name = "device")
    @Column(name = "IsEquipped")
    protected Map<Device, Boolean> devices;

    public Ranged(String name, WeaponMount pos) {
        super(name, pos);
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
}
