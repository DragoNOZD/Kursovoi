package ru.mmo.database.item.augm_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.Rarity;

import java.util.List;

@Service
public class AugmImplServiceImpl implements AugmImplService {

	private AugmImplRepository repository;

	@Autowired
	public AugmImplServiceImpl(AugmImplRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addAugmImpl(Augmentation_Implant augmentationImplant) {
		repository.saveAndFlush(augmentationImplant);
	}

	@Override
	public void deleteAugmImpl(Augmentation_Implant augmentationImplant) {
		repository.delete(augmentationImplant);
	}

	@Override
	public void updateAugmImpl(Augmentation_Implant augmentationImplant) {
		addAugmImpl(augmentationImplant);
	}

	@Override
	public Augmentation_Implant getAugmImpl(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Augmentation_Implant> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Augmentation_Implant> getAllByName(String name) {
		return repository.getAllByName(name);
	}

	@Override
	public List<Augmentation_Implant> getAllByRarity(Rarity rarity) {
		return repository.getAllByRarity(rarity);
	}

	@Override
	public List<Augmentation_Implant> getAllByType(AugmImplType type) {
		return repository.getAllByType(type);
	}

	@Override
	public List<Augmentation_Implant> getAllByUsageType(AugmImplUsageType usageType) {
		return repository.getAllByUsageType(usageType);
	}
}
