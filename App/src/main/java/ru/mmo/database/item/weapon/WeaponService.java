package ru.mmo.database.item.weapon;

import ru.mmo.database.item.Rarity;

import java.util.List;

public interface WeaponService {
    void addWeapon(Weapon weapon);
    void deleteWeapon(Weapon weapon);
    void updateWeapon(Weapon weapon);
    Weapon getWeaponById(Long id);
    List<Weapon> getAll();
    List<Weapon> getAllByName(String name);
    List<Weapon> getAllByRarity(Rarity rarity);
    List<Weapon> getAllByMount(WeaponMount mount);
}
