package ru.mmo.database.npc;

import ru.mmo.database.character.Character;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class NPC extends Character {

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
