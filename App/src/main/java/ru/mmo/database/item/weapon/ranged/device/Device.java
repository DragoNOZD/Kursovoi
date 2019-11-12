package ru.mmo.database.item.weapon.ranged.device;

import ru.mmo.database.item.Item;
import ru.mmo.database.item.weapon.ranged.Ranged;

import javax.persistence.*;

@Entity
public class Device extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    protected DeviceType type;

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

    public void use(Ranged ranged){

    }
}
