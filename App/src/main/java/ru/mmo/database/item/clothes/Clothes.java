package ru.mmo.database.item.clothes;

import ru.mmo.database.item.Item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Clothes extends Item {

    @Column
    protected int damageReductionPercentage;

    @Enumerated(EnumType.STRING)
    @Column
    protected ClothesType type;

    public Clothes(String name, int damageReductionPercentage, ClothesType type) {
        super(name);
        this.damageReductionPercentage = damageReductionPercentage;
        this.type = type;
    }

    public int getDamageReductionPercentage() {
        return damageReductionPercentage;
    }

    public void setDamageReductionPercentage(int damageReductionPercentage) {
        this.damageReductionPercentage = damageReductionPercentage;
    }

    public ClothesType getType() {
        return type;
    }

    public void setType(ClothesType type) {
        this.type = type;
    }
}
