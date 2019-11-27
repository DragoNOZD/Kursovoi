package ru.mmo.database.actor.npc;

import java.util.List;

public interface NPCService {
	void addNPC(NPC npc);
	void deleteNPC(NPC npc);
	void updateNPC(NPC npc);
	NPC getNPCById(Long id);
	List<NPC> getAll();
	List<NPC> getAllByName(String name);
}
