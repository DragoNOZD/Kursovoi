package ru.mmo.database.acceptedquests;

import ru.mmo.database.player.PlayerCharacter;
import ru.mmo.database.quest.Quest;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AcceptedQuestsId implements Serializable {

    @ManyToOne
    protected Quest quest;

    @ManyToOne
    protected PlayerCharacter character;

    public AcceptedQuestsId(Quest quest, PlayerCharacter character) {
        this.quest = quest;
        this.character = character;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public PlayerCharacter getCharacter() {
        return character;
    }

    public void setCharacter(PlayerCharacter character) {
        this.character = character;
    }
}
