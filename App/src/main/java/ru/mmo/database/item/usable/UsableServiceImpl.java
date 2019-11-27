package ru.mmo.database.item.usable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.Rarity;

import java.util.List;

@Service
public class UsableServiceImpl implements UsableService {

	private UsableRepository repository;

	@Autowired
	public UsableServiceImpl(UsableRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addItem(Usable item) {
		repository.saveAndFlush(item);
	}

	@Override
	public void deleteItem(Usable item) {
		repository.delete(item);
	}

	@Override
	public void updateItem(Usable item) {
		addItem(item);
	}

	@Override
	public Usable getItem(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Usable> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Usable> getAllByName(String name) {
		return repository.getAllByName(name);
	}

	@Override
	public List<Usable> getAllByRarity(Rarity rarity) {
		return repository.getAllByRarity(rarity);
	}

	@Override
	public List<Usable> getAllByType(UsableItemType itemType) {
		return repository.getAllByItem(itemType);
	}
}
