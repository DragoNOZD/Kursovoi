package ru.mmo.database.item.clothes;

import ru.mmo.database.item.Rarity;

import java.util.List;

public interface ClothesService {
	void addClothes(Clothes clothes);
	void deleteClothes(Clothes clothes);
	void updaateClothes(Clothes clothes);
	Clothes getClothes(Long id);
	List<Clothes> getAll();
	List<Clothes> getAllByName(String name);
	List<Clothes> getAllByRarity(Rarity rarity);
	List<Clothes> getAllByType(ClothesType type);
	List<Clothes> getAllByMinDamageReduction(double minDR);
	List<Clothes> getAllByMaxDamageReduction(double maxDR);
	List<Clothes> getAllByDamageReductionBetween(double maxDR, double minDR);
}
