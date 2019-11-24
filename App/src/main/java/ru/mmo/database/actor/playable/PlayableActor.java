package ru.mmo.database.actor.playable;

import org.springframework.beans.factory.annotation.Autowired;
import ru.mmo.database.account.Account;
import ru.mmo.database.actor.Actor;
import ru.mmo.database.quest.Quest;

import javax.persistence.*;
import java.util.Map;

@Entity
public class PlayableActor extends Actor {

    @Transient
    @Autowired
    private PlayableActorService service;

    @ManyToOne(fetch = FetchType.LAZY)
    protected Account owner;

    @Column
    protected float exp;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "accepted_quests",
            joinColumns = { @JoinColumn(name = "quest") }
    )
    @MapKeyJoinColumn(name = "actor")
    @Column(name = "IsCompleted")
    protected Map<Quest, Boolean> quests;

    public PlayableActor(String name, Account owner) {
        this.name = name;
        this.owner = owner;
        service.addActor(this);
    }

    public PlayableActor() {
    }

    @Override
    public void updateActor(){
        service.updateActor(this);
    }

    public Account getOwner() {
        return owner;
    }

    public void setOwner(Account owner) {
        this.owner = owner;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    public PlayableActorService getService() {
        return service;
    }

    public void setService(PlayableActorService service) {
        this.service = service;
    }

    public Map<Quest, Boolean> getQuests() {
        return quests;
    }

    public void setQuests(Map<Quest, Boolean> quests) {
        this.quests = quests;
    }
}
