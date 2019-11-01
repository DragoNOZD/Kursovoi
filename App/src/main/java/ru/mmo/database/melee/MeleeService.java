package ru.mmo.database.melee;

import ru.mmo.database.Rarity;

import java.util.List;

public interface MeleeService {
    void addMelee(Melee melee);
    void deleteMelee(Melee melee);
    void updateMelee(Melee melee);
    Melee getMelee(Long id);
    List<Melee> getAll();
    List<Melee> getAllByRarity(Rarity rarity);
    List<Melee> getAllByName(String name);
}
