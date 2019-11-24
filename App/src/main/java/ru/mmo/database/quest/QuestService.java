package ru.mmo.database.quest;

import ru.mmo.database.actor.npc.NPC;

import java.util.List;

public interface QuestService {
	void addQuest(Quest quest);
	void deleteQuest(Quest quest);
	void updateQuest(Quest quest);
	Quest getQuest(Long id);
	List<Quest> getAll();
	List<Quest> getAllByType(QuestType type);
}
