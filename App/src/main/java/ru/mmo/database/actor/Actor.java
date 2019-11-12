package ru.mmo.database.actor;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import ru.mmo.database.account.AccountService;
import ru.mmo.database.actor.skills.Skill;
import ru.mmo.database.hibernatetypes.vector.Vector;
import ru.mmo.database.hibernatetypes.vector.VectorHibernateType;
import ru.mmo.database.item.Item;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@TypeDefs({
        @TypeDef(typeClass = VectorHibernateType.class, defaultForType = Vector.class)
})
@Configurable
public class Actor {

    @Autowired
    @Transient
    private ActorService service;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "Actor_generator")
    @SequenceGenerator(name = "Actor_generator",
            sequenceName = "Actor_sequence")
    protected long id;

    @Column
    protected String name;

    @Column
    protected int maxHP;

    @Column
    protected int HPPersentage;

    @Transient
    protected int HP;

    @Column(columnDefinition = "vector3")
    protected Vector location;

    @Column
    protected String mesh;

    @ManyToMany
    protected List<Item> inventory;

    @ElementCollection
    @CollectionTable(name = "actor_skills",
            joinColumns = { @JoinColumn(name = "actor") }
    )
    @MapKeyJoinColumn(name = "skill")
    @Column(name = "IsEquipped")
    protected Map<Skill, Boolean> skills;

    public Actor(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
    }

    public Actor() {
    }

    private void updateActor(){
        service.updateCharacter(this);
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

    public Map<Skill, Boolean> getSkills() {
        return skills;
    }

    public void setSkills(Map<Skill, Boolean> skills) {
        this.skills = skills;
    }

    public ActorService getService() {
        return service;
    }

    public void setService(ActorService service) {
        this.service = service;
    }

    public String getMesh() {
        return mesh;
    }

    public void setMesh(String mesh) {
        this.mesh = mesh;
    }
}
