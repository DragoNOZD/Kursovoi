package ru.mmo.database.actor.npc;

import ru.mmo.database.actor.Actor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class NPC extends Actor {

    @Column
    protected boolean bIsEnemy;

    public NPC(String name, int maxHP) {
        super(name, maxHP);
    }

    public boolean isEnemy() {
        return bIsEnemy;
    }

    public void setIsEnemy(boolean bIsEnemy) {
        this.bIsEnemy = bIsEnemy;
    }
}
