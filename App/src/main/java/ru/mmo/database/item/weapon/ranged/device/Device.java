package ru.mmo.database.item.weapon.ranged.device;

import ru.mmo.database.item.Item;
import ru.mmo.database.item.weapon.ranged.Ranged;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Device extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    protected DeviceType type;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "ranged_devices",
            joinColumns = { @JoinColumn(name = "ranged") }
    )
    @MapKeyJoinColumn(name = "device")
    @Column(name = "IsEquipped")
    private Map<Ranged, Boolean> weapons;

    public Device(String name, DeviceType type) {
        super(name);
        this.type = type;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public Map<Ranged, Boolean> getWeapons() {
        return weapons;
    }

    public void setWeapons(Map<Ranged, Boolean> weapons) {
        this.weapons = weapons;
    }

    public void use(Ranged ranged){

    }
}
