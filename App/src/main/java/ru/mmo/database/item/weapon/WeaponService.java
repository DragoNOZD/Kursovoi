package ru.mmo.database.item.weapon;

import java.util.List;

public interface WeaponService {
    void addWeapon(Weapon weapon);
    void deleteWeapon(Weapon weapon);
    void updateWeapon(Weapon weapon);
    Weapon getWeaponById(Long id);
    List<Weapon> getAll();
}
