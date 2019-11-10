package ru.mmo.database.item.weapon.melee.combo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Combo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Combo_generator")
    @SequenceGenerator(name = "Combo_generator", sequenceName = "Combo_sequence")
    private long id;

    @Column
    private float damage;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Action> seq;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Condition> conditions;

    public Combo(float damage) {
        this.damage = damage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public List<Action> getSeq() {
        return seq;
    }

    public void setSeq(List<Action> seq) {
        this.seq = seq;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
