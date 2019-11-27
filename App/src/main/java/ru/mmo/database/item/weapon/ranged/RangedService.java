package ru.mmo.database.item.weapon.ranged;

import ru.mmo.database.item.Rarity;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.ranged.device.Device;
import ru.mmo.database.item.weapon.ranged.projectile.Projectile;

import java.util.List;

public interface RangedService {
	void addRanged(Ranged ranged);
	void deleteRanged(Ranged ranged);
	void updateRanged(Ranged ranged);
	Ranged getRanged(Long id);
	List<Ranged> getAll();
	List<Ranged> getAllByName(String name);
	List<Ranged> getAllByRarity(Rarity rarity);
	List<Ranged> getAllByMount(WeaponMount mount);
	List<Ranged> getAllByMinProjectileStartSpeed(double minPSS);
	List<Ranged> getAllByMaxProjectileStartSpeed(double maxPSS);
	List<Ranged> getAllByProjectileStartSpeed(double minPSS, double maxPSS);
	List<Ranged> getAllByMinMagazineCount(double minMC);
	List<Ranged> getAllByMaxMagazineCount(double maxMC);
	List<Ranged> getAllByMagazineCount(double minMC, double maxMC);
}
