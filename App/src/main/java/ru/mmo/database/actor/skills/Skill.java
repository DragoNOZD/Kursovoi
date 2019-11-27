package ru.mmo.database.actor.skills;

import ru.mmo.database.actor.Actor;

import javax.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Skill_generator")
    @SequenceGenerator(name = "Skill_generator", sequenceName = "Skill_sequence")
    private long id;

    @Column
    private float val;

    @Enumerated(EnumType.STRING)
    @Column
    private SkillType type;

    public Skill() {
    }

    public Skill(float val) {
        this.val = val;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    public void use(Actor actor){

    }
}
