package ru.mmo.database.actor;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.mmo.database.actor.skills.Skill;
import ru.mmo.database.hibernate.types.vector.Vector;
import ru.mmo.database.hibernate.types.vector.VectorHibernateType;
import ru.mmo.database.item.Item;

import javax.persistence.*;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@TypeDefs({
        @TypeDef(typeClass = VectorHibernateType.class, defaultForType = Vector.class)
})
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Actor_generator")
    @SequenceGenerator(name = "Actor_generator",
            sequenceName = "Actor_sequence")
    protected long id;

    @Column
    protected String name;

    @Column
    protected float maxHP;

    @Transient
    protected float HP;

    @Column(columnDefinition = "vector3")
    protected Vector location;

    @Column
    protected String mesh;

    @ElementCollection
    @CollectionTable(name = "inventory",
            joinColumns = { @JoinColumn(name = "actor") }
    )
    @MapKeyJoinColumn(name = "item")
    @Column(name = "actor_slot_or_count")
    protected Map<Item, Integer> inventory;

    @ElementCollection
    @CollectionTable(name = "actor_skills",
            joinColumns = { @JoinColumn(name = "actor") }
    )
    @MapKeyJoinColumn(name = "skill")
    @Column(name = "IsEquipped")
    protected Map<Skill, Boolean> skills;

    public Actor(String name) {
        this.name = name;
    }

    public Actor() {
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

    public float getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(float maxHP) {
        this.maxHP = maxHP;
    }

    public int getHPPercentage() {
        return (int)(maxHP*100/HP);
    }

    public float getHP() {
        return HP;
    }

    public void setHP(float HP) {
        this.HP = HP;
    }

    public Vector getLocation() {
        return location;
    }

    public void setLocation(Vector location) {
        this.location = location;
    }

    public Map<Item, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(Map<Item, Integer> inventory) {
        this.inventory = inventory;
    }

    public Map<Skill, Boolean> getSkills() {
        return skills;
    }

    public void setSkills(Map<Skill, Boolean> skills) {
        this.skills = skills;
    }

    public String getMesh() {
        return mesh;
    }

    public void setMesh(String mesh) {
        this.mesh = mesh;
    }
}
