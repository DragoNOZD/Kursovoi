package ru.mmo.database.actor.skills;

import ru.mmo.database.actor.Actor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Skill_generator")
    @SequenceGenerator(name = "Skill_generator", sequenceName = "Skill_sequence")
    protected long id;

    @Column
    protected float val;

    @Enumerated(EnumType.STRING)
    @Column
    protected SkillType type;

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
