package ru.mmo.database.actor.npc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NPCServiceImpl implements NPCService{

	private NPCRepository repository;

	@Autowired
	public NPCServiceImpl(NPCRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addNPC(NPC npc) {
		repository.saveAndFlush(npc);
	}

	@Override
	public void deleteNPC(NPC npc) {
		repository.delete(npc);
	}

	@Override
	public void updateNPC(NPC npc) {
		addNPC(npc);
	}

	@Override
	public NPC getNPCById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<NPC> getAll() {
		return repository.findAll();
	}

	@Override
	public List<NPC> getAllByName(String name) {
		return repository.getAllByName(name);
	}
}
