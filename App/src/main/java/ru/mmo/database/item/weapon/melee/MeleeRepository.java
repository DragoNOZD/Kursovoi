package ru.mmo.database.item.weapon.melee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;
import ru.mmo.database.item.weapon.Weapon;
import ru.mmo.database.item.weapon.WeaponMount;

import java.util.List;

public interface MeleeRepository extends JpaRepository<Melee, Long> {

    @Query("SELECT m from Melee m where m.rarity = :rarity")
    List<Melee> getAllByRarity(@Param("rarity") Rarity rarity);

    @Query("select m from Melee m where m.name = :name")
    List<Melee> getAllByName(@Param("name") String name);

    @Query("select m from Melee m where m.mount = :mount")
    List<Melee> getAllByMount(@Param("mount") WeaponMount mount);
}
