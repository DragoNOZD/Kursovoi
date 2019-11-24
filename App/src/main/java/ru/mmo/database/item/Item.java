package ru.mmo.database.item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Item_generator")
    @SequenceGenerator(name = "Item_generator", sequenceName = "Item_sequence")
    protected long id;

    @Column
    protected String name;

    @Column
    protected String mesh;

    @Enumerated(EnumType.STRING)
    @Column
    protected Rarity rarity = Rarity.C;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
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

    public String getMesh() {
        return mesh;
    }

    public void setMesh(String mesh) {
        this.mesh = mesh;
    }

    public Rarity getRarity() {

        long c = rarity.getCount();

        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
}
