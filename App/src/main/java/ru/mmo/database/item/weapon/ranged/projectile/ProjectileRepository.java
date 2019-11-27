package ru.mmo.database.item.weapon.ranged.projectile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;

import java.util.List;

public interface ProjectileRepository extends JpaRepository<Projectile, Long> {

	@Query("SELECT i from Projectile i where i.rarity = :rarity")
	List<Projectile> getAllByRarity(@Param("rarity") Rarity rarity);

	@Query("select i from Projectile i where i.name = :name")
	List<Projectile> getAllByName(@Param("name") String name);

	@Query("select i from Projectile i where i.type = :projType")
	List<Projectile> getAllByType(@Param("projType") ProjectileType type);

	@Query("select i from Projectile i where i.damage >= :minDamage and i.damage <= :maxDamage")
	List<Projectile> getAllByDamageBetween(@Param("minDamage") float minDamage, @Param("maxDamage") float maxDamage);
}
