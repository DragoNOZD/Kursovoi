package ru.mmo.database.item.clothes;

import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
public class Clothes extends Item {

    @Column
    private int damageReduction;

    @Enumerated(EnumType.STRING)
    @Column
    private ClothesType type;

    public Clothes(String name, int damageReduction, ClothesType type) {
        super(name);
        this.damageReduction = damageReduction;
        this.type = type;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public ClothesType getType() {
        return type;
    }

    public void setType(ClothesType type) {
        this.type = type;
    }
}
