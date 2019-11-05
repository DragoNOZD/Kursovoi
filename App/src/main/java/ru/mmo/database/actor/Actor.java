package ru.mmo.database.actor;

import ru.mmo.database.Vector;
import ru.mmo.database.item.Item;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Actor {

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
    protected Vector location;

    @ManyToMany
    private List<Item> inventory;

    public Actor(String name, int maxHP) {
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

    public Vector getLocation() {
        return location;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
