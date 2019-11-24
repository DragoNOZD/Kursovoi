package ru.mmo.database.item.weapon.melee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.ItemRepository;
import ru.mmo.database.item.Rarity;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.WeaponRepository;

import java.util.List;

@Service
public class MeleeServiceImpl implements MeleeService {

    private MeleeRepository meleeRepository;

    @Autowired
    public MeleeServiceImpl(MeleeRepository meleeRepository) {
        this.meleeRepository = meleeRepository;
    }

    @Override
    public void addMelee(Melee melee) {
        meleeRepository.saveAndFlush(melee);
    }

    @Override
    public void deleteMelee(Melee melee) {
        meleeRepository.delete(melee);
    }

    @Override
    public void updateMelee(Melee melee) {
        addMelee(melee);
    }

    @Override
    public Melee getMelee(Long id) {
        return meleeRepository.getOne(id);
    }

    @Override
    public List<Melee> getAll() {
        return meleeRepository.findAll();
    }

    @Override
    public List<Melee> getAllByRarity(Rarity rarity) {
        return meleeRepository.getAllByRarity(rarity);
    }

    @Override
    public List<Melee> getAllByName(String name) {
        return meleeRepository.getAllByName(name);
    }

    @Override
    public List<Melee> getAllByMount(WeaponMount mount) {
        return meleeRepository.getAllByMount(mount);
    }
}
