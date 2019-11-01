package ru.mmo.database.item;

import ru.mmo.database.Rarity;

import java.util.List;

public interface ItemService {
    void addItem(Item item);
    void deleteItem(Item item);
    void updateItem(Item item);
    Item getItem(Long id);
    List<Item> getAllByRarity(Rarity rarity);
    List<Item> getAllByName(String name);
    List<Item> getAll();
}
