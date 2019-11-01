package ru.mmo.database.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.Rarity;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addItem(Item item) {
        repository.saveAndFlush(item);
    }

    @Override
    public void deleteItem(Item item) {
        repository.delete(item);
    }

    @Override
    public void updateItem(Item item) {
        addItem(item);
    }

    @Override
    public Item getItem(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Item> getAllByRarity(Rarity rarity) {
        return repository.getAllByRarity(rarity);
    }

    @Override
    public List<Item> getAllByName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public List<Item> getAll() {
        return repository.findAll();
    }
}
