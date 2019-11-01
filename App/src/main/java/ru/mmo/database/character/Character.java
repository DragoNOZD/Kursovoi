package ru.mmo.database.character;

import ru.mmo.database.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Character {

    @Id
    @GeneratedValue
    protected long id;

    @Column
    protected String name;

    @Column
    protected int maxHP;

    @Column
    protected int HPPersentage;

    protected int HP;

    @Column
    protected float X_Location;

    @Column
    protected float Y_Location;

    @Column
    protected float Z_Location;

    @ManyToMany
    private List<Item> inventory;

    public Character(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHPPersentage() {
        return HPPersentage;
    }

    public void setHPPersentage(int HPPersentage) {
        this.HPPersentage = HPPersentage;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public float getX_Location() {
        return X_Location;
    }

    public void setX_Location(float x_Location) {
        X_Location = x_Location;
    }

    public float getY_Location() {
        return Y_Location;
    }

    public void setY_Location(float y_Location) {
        Y_Location = y_Location;
    }

    public float getZ_Location() {
        return Z_Location;
    }

    public void setZ_Location(float z_Location) {
        Z_Location = z_Location;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
