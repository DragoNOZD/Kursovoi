package ru.mmo.database.quest.acceptedquests;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class AcceptedQuests {

    @EmbeddedId
    protected AcceptedQuestsId id;

    @Column
    protected boolean completed;

    public AcceptedQuests() {
        completed = false;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
