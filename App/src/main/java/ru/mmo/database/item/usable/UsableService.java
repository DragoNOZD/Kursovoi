package ru.mmo.database.item.usable;

import ru.mmo.database.item.Rarity;

import java.util.List;

public interface UsableService {
	void addItem(Usable item);
	void deleteItem(Usable item);
	void updateItem(Usable item);
	Usable getItem(Long id);
	List<Usable> getAll();
	List<Usable> getAllByName(String name);
	List<Usable> getAllByRarity(Rarity rarity);
	List<Usable> getAllByType(UsableItemType itemType);
}
