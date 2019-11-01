package ru.mmo.database.item.weapon.melee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.Rarity;

import java.util.List;

@Service
public class MeleeServiceImpl implements MeleeService {

    private MeleeRepository repository;

    @Autowired
    public MeleeServiceImpl(MeleeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addMelee(Melee melee) {
        repository.saveAndFlush(melee);
    }

    @Override
    public void deleteMelee(Melee melee) {
        repository.delete(melee);
    }

    @Override
    public void updateMelee(Melee melee) {
        addMelee(melee);
    }

    @Override
    public Melee getMelee(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Melee> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Melee> getAllByRarity(Rarity rarity) {
        return repository.getAllByRarity(rarity);
    }

    @Override
    public List<Melee> getAllByName(String name) {
        return repository.getAllByName(name);
    }


}
