package ru.mmo.database.combo;

import ru.mmo.database.melee.Melee;

import java.util.List;

public interface ComboService {
    void addCombo(Combo combo);
    void deleteCombo(Combo combo);
    void updateCombo(Combo combo);
    Combo getCombo(Long id);
    List<Combo> getAllByWepon(Melee melee);
    List<Combo> getAll();
}
