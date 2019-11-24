package ru.mmo.database.item.augm_impl;

import ru.mmo.database.item.Rarity;

import java.util.List;

public interface AugmImplService {
	void addAugmImpl(Augmentation_Implant augmentationImplant);
	void deleteAugmImpl(Augmentation_Implant augmentationImplant);
	void updateAugmImpl(Augmentation_Implant augmentationImplant);
	Augmentation_Implant getAugmImpl(Long id);
	List<Augmentation_Implant> getAll();
	List<Augmentation_Implant> getAllByName(String name);
	List<Augmentation_Implant> getAllByRarity(Rarity rarity);
	List<Augmentation_Implant> getAllByType(AugmImplType type);
	List<Augmentation_Implant> getAllByUsageType(AugmImplUsageType usageType);
}
