package ru.mmo.database.quest;

import ru.mmo.database.actor.npc.NPC;
import ru.mmo.database.actor.playable.PlayableActor;
import ru.mmo.database.quest.questparts.QuestPart;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Quest_generator")
    @SequenceGenerator(name = "Quest_generator", sequenceName = "Quest_sequence")
    protected long id;

    @Column
    protected String name;

    // reward

    @Enumerated(EnumType.STRING)
    @Column
    protected QuestType type;

    @ManyToOne
    protected NPC npc;

    @OneToMany
    protected List<QuestPart> parts;

    @ElementCollection
    @CollectionTable(name = "accepted_quests",
            joinColumns = { @JoinColumn(name = "quest") }
    )
    @MapKeyJoinColumn(name = "actor")
    @Column(name = "IsCompleted")
    protected Map<PlayableActor, Boolean> actors;

    public Quest(String name, QuestType type, NPC npc) {
        this.name = name;
        this.type = type;
        this.npc = npc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuestType getType() {
        return type;
    }

    public void setType(QuestType type) {
        this.type = type;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }

    public List<QuestPart> getParts() {
        return parts;
    }

    public void setParts(List<QuestPart> parts) {
        this.parts = parts;
    }

    public void addPart(QuestPart part){
        parts.add(part);
    }
}
