package ru.mmo.database.item.usable;

import ru.mmo.database.actor.Actor;
import ru.mmo.database.item.Item;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Usable extends Item {

    @Column
    protected UsableItemType itemType;

    public Usable(String name, UsableItemType itemType) {
        super(name);
        this.itemType = itemType;
    }

    public UsableItemType getItemType() {
        return itemType;
    }

    public void setItemType(UsableItemType itemType) {
        this.itemType = itemType;
    }

    public void use(Actor actor){

    }
}
