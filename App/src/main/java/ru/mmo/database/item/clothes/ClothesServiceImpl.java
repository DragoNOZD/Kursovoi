package ru.mmo.database.item.clothes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.Rarity;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {

	private ClothesRepository repository;

	@Autowired
	public ClothesServiceImpl(ClothesRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addClothes(Clothes clothes) {
		repository.saveAndFlush(clothes);
	}

	@Override
	public void deleteClothes(Clothes clothes) {
		repository.delete(clothes);
	}

	@Override
	public void updaateClothes(Clothes clothes) {
		addClothes(clothes);
	}

	@Override
	public Clothes getClothes(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Clothes> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Clothes> getAllByName(String name) {
		return repository.getAllByName(name);
	}

	@Override
	public List<Clothes> getAllByRarity(Rarity rarity) {
		return repository.getAllByRarity(rarity);
	}

	@Override
	public List<Clothes> getAllByType(ClothesType type) {
		return repository.getAllByType(type);
	}

	@Override
	public List<Clothes> getAllByMinDamageReduction(double minDR) {
		return repository.getAllByDamageReductionBetween(minDR, 1000);
	}

	@Override
	public List<Clothes> getAllByMaxDamageReduction(double maxDR) {
		return repository.getAllByDamageReductionBetween(0, maxDR);
	}

	@Override
	public List<Clothes> getAllByDamageReductionBetween(double maxDR, double minDR) {
		return repository.getAllByDamageReductionBetween(minDR, maxDR);
	}
}
