package ru.mmo.database.quest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {

	private QuestRepository repository;

	@Autowired
	public QuestServiceImpl(QuestRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addQuest(Quest quest) {
		repository.saveAndFlush(quest);
	}

	@Override
	public void deleteQuest(Quest quest) {
		repository.delete(quest);
	}

	@Override
	public void updateQuest(Quest quest) {
		addQuest(quest);
	}

	@Override
	public Quest getQuest(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Quest> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Quest> getAllByType(QuestType type) {
		return repository.getAllByType(type);
	}
}
