package ru.mmo.database.item.weapon.melee.combo;

import ru.mmo.database.item.weapon.melee.Melee;

import java.util.List;

public interface ComboService {
    void addCombo(Combo combo);
    void deleteCombo(Combo combo);
    void updateCombo(Combo combo);
    Combo getCombo(Long id);
    List<Combo> getAll();
}
