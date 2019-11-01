package ru.mmo.database.quest.acceptedquests;

import ru.mmo.database.actor.playable.PlayableActor;
import ru.mmo.database.quest.Quest;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class AcceptedQuestsId implements Serializable {

    @ManyToOne
    protected Quest quest;

    @ManyToOne
    protected PlayableActor character;

    public AcceptedQuestsId(Quest quest, PlayableActor character) {
        this.quest = quest;
        this.character = character;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setQuest(Quest quest) {
        this.quest = quest;
    }

    public PlayableActor getCharacter() {
        return character;
    }

    public void setCharacter(PlayableActor character) {
        this.character = character;
    }
}
