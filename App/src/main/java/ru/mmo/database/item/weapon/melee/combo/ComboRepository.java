package ru.mmo.database.item.weapon.melee.combo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.weapon.melee.Melee;

import java.util.List;

public interface ComboRepository extends JpaRepository<Combo, Long> {

    @Query("SELECT c from Combo c where c.weapon = :weaponn")
    List<Combo> getAllByWeapon(@Param("weapon") Melee weapon);

}
