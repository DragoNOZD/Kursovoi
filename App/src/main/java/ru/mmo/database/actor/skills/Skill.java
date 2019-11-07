package ru.mmo.database.actor.skills;

import ru.mmo.database.actor.Actor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Skill {

    @Column
    protected float val;

    public Skill() {
    }

    public Skill(float val) {
        this.val = val;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    public void use(Actor actor){

    }
}
