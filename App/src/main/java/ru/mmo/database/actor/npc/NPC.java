package ru.mmo.database.actor.npc;

import ru.mmo.database.actor.Actor;
import ru.mmo.database.actor.playable.PlayableActor;
import ru.mmo.database.quest.Quest;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class NPC extends Actor {

    @ElementCollection
    @CollectionTable(name = "hostility_to_player",
            joinColumns = @JoinColumn(name = "NPC")
    )
    @MapKeyJoinColumn(name = "player")
    @Column(name = "hostility")
    protected Map<PlayableActor, Double> hostility;

    @Enumerated(EnumType.STRING)
    @Column
    protected NPCType type;

    @OneToMany(mappedBy = "npc", fetch = FetchType.LAZY)
    protected List<Quest> quests;

    public NPC(String name) {
        super(name);
    }

    public NPC() {
    }

    public Map<PlayableActor, Double> getHostility() {
        return hostility;
    }

    public void setHostility(Map<PlayableActor, Double> hostility) {
        this.hostility = hostility;
    }

    public NPCType getType() {
        return type;
    }

    public void setType(NPCType type) {
        this.type = type;
    }
}
