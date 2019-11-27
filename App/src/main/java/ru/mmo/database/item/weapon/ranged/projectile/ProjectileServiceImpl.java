package ru.mmo.database.item.weapon.ranged.projectile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.Rarity;

import java.util.List;

@Service
public class ProjectileServiceImpl implements ProjectileService {

	private ProjectileRepository repository;

	@Autowired
	public ProjectileServiceImpl(ProjectileRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addProjectile(Projectile projectile) {
		repository.saveAndFlush(projectile);
	}

	@Override
	public void deleteProjectile(Projectile projectile) {
		repository.delete(projectile);
	}

	@Override
	public void updateProjectile(Projectile projectile) {
		addProjectile(projectile);
	}

	@Override
	public Projectile getProjectile(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Projectile> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Projectile> getAllByName(String name) {
		return repository.getAllByName(name);
	}

	@Override
	public List<Projectile> getAllByRarity(Rarity rarity) {
		return repository.getAllByRarity(rarity);
	}

	@Override
	public List<Projectile> getAllByType(ProjectileType type) {
		return repository.getAllByType(type);
	}

	@Override
	public List<Projectile> getAllByMinDamage(float minD) {
		return repository.getAllByDamageBetween(minD, 1000);
	}

	@Override
	public List<Projectile> getAllByMaxDamage(float maxD) {
		return repository.getAllByDamageBetween(0, maxD);
	}

	@Override
	public List<Projectile> getAllByDamageBetween(float maxD, float minD) {
		return repository.getAllByDamageBetween(minD, maxD);
	}
}
