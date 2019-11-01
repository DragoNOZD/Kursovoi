package ru.mmo.database.quest;

import ru.mmo.database.npc.NPC;
import ru.mmo.database.questparts.QuestPart;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quest {

    @Id
    @GeneratedValue
    protected long id;

    @Column
    protected String name;

    // reward

    @Column
    protected QuestType type;

    @ManyToOne
    protected NPC npc;

    @OneToMany
    protected List<QuestPart> parts;

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
