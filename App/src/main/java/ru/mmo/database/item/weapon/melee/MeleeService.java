package ru.mmo.database.item.weapon.melee;

import ru.mmo.database.item.Rarity;
import ru.mmo.database.item.weapon.WeaponMount;

import java.util.List;

public interface MeleeService {
    void addMelee(Melee melee);
    void deleteMelee(Melee melee);
    void updateMelee(Melee melee);
    Melee getMelee(Long id);
    List<Melee> getAll();
    List<Melee> getAllByRarity(Rarity rarity);
    List<Melee> getAllByName(String name);
    List<Melee> getAllByMount(WeaponMount mount);
}
