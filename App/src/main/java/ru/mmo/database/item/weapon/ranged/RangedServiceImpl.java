package ru.mmo.database.item.weapon.ranged;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.Rarity;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.ranged.device.Device;
import ru.mmo.database.item.weapon.ranged.projectile.Projectile;

import java.util.List;

@Service
public class RangedServiceImpl implements RangedService {

	private RangedRepository repository;

	@Autowired
	public RangedServiceImpl(RangedRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addRanged(Ranged ranged) {
		repository.saveAndFlush(ranged);
	}

	@Override
	public void deleteRanged(Ranged ranged) {
		repository.delete(ranged);
	}

	@Override
	public void updateRanged(Ranged ranged) {
		addRanged(ranged);
	}

	@Override
	public Ranged getRanged(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Ranged> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Ranged> getAllByName(String name) {
		return repository.getAllByName(name);
	}

	@Override
	public List<Ranged> getAllByRarity(Rarity rarity) {
		return repository.getAllByRarity(rarity);
	}

	@Override
	public List<Ranged> getAllByMount(WeaponMount mount) {
		return repository.getAllByMount(mount);
	}

	@Override
	public List<Ranged> getAllByMinProjectileStartSpeed(double minPSS) {
		return repository.getAllByProjectileStartSpeed(minPSS, 10000);
	}

	@Override
	public List<Ranged> getAllByMaxProjectileStartSpeed(double maxPSS) {
		return repository.getAllByProjectileStartSpeed(0, maxPSS);
	}

	@Override
	public List<Ranged> getAllByProjectileStartSpeed(double minPSS, double maxPSS) {
		return repository.getAllByProjectileStartSpeed(minPSS, maxPSS);
	}

	@Override
	public List<Ranged> getAllByMinMagazineCount(double minMC) {
		return repository.getAllByMagazineCount(minMC, 1000);
	}

	@Override
	public List<Ranged> getAllByMaxMagazineCount(double maxMC) {
		return repository.getAllByMagazineCount(0, maxMC);
	}

	@Override
	public List<Ranged> getAllByMagazineCount(double minMC, double maxMC) {
		return repository.getAllByMagazineCount(minMC, maxMC);
	}
}
