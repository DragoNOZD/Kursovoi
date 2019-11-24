package ru.mmo.database.item.weapon.ranged.projectile;

import ru.mmo.database.item.Rarity;

import java.util.List;

public interface ProjectileService {
	void addProjectile(Projectile projectile);
	void deleteProjectile(Projectile projectile);
	void updateProjectile(Projectile projectile);
	Projectile getProjectile(Long id);
	List<Projectile> getAll();
	List<Projectile> getAllByName(String name);
	List<Projectile> getAllByRarity(Rarity rarity);
	List<Projectile> getAllByType(ProjectileType type);
	List<Projectile> getAllByMinDamage(float minD);
	List<Projectile> getAllByMaxDamage(float maxD);
	List<Projectile> getAllByDamageBetween(float maxD, float minD);
}
