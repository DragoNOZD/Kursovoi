package ru.mmo.database.item.weapon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;

import java.util.List;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

	@Query("SELECT i from Weapon i where i.rarity = :rarity")
	List<Weapon> getAllByRarity(@Param("rarity") Rarity rarity);

	@Query("select i from Weapon i where i.name = :name")
	List<Weapon> getAllByName(@Param("name") String name);

	@Query("select i from Weapon i where i.mount = :mount")
	List<Weapon> getAllByMount(@Param("mount") WeaponMount mount);
}
