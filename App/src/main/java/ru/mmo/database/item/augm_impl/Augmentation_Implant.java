package ru.mmo.database.item.augm_impl;

import ru.mmo.database.actor.Actor;
import ru.mmo.database.item.Item;
import ru.mmo.database.item.augm_impl.augmimplaction.AugmImplAction;

import javax.persistence.*;
import java.util.List;

@Entity
public class Augmentation_Implant extends Item {

    @Enumerated(EnumType.STRING)
    @Column
    protected AugmImplType type;

    @Enumerated(EnumType.STRING)
    @Column
    protected AugmImplUsageType usageType;

    @ElementCollection
    protected List<AugmImplAction> actions;

    public Augmentation_Implant(String name) {
        super(name);
    }

    public AugmImplType getType() {
        return type;
    }

    public void setType(AugmImplType type) {
        this.type = type;
    }

    public AugmImplUsageType getUsageType() {
        return usageType;
    }

    public void setUsageType(AugmImplUsageType usageType) {
        this.usageType = usageType;
    }

    public void use(Actor actor){

    }
}
