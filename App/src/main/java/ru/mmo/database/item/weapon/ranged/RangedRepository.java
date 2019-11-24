package ru.mmo.database.item.weapon.ranged;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.ranged.device.Device;
import ru.mmo.database.item.weapon.ranged.projectile.Projectile;

import java.util.List;

public interface RangedRepository extends JpaRepository<Ranged, Long> {

	@Query("SELECT i from Ranged i where i.rarity = :rarity")
	List<Ranged> getAllByRarity(@Param("rarity") Rarity rarity);

	@Query("select i from Ranged i where i.name = :name")
	List<Ranged> getAllByName(@Param("name") String name);

	@Query("select i from Ranged i where i.mount = :mount")
	List<Ranged> getAllByMount(@Param("mount")WeaponMount mount);

	@Query("select i from Ranged i where i.projectileStartSpeed >= :minSpeed and i.projectileStartSpeed <= :maxSpeed")
	List<Ranged> getAllByProjectileStartSpeed(@Param("minSpeed") double minSpeed, @Param("maxSpeed") double maxSpeed);

	@Query("select i from Ranged i where i.maxMagazineCount >= :minCount and i.maxMagazineCount <= :maxCount")
	List<Ranged> getAllByMagazineCount(@Param("minCount") double minCount, @Param("maxCount") double maxCount);
}
