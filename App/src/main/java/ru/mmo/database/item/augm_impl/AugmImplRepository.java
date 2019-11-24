package ru.mmo.database.item.augm_impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;

import java.util.List;

public interface AugmImplRepository extends JpaRepository<Augmentation_Implant, Long> {

	@Query("SELECT i from Augmentation_Implant i where i.rarity = :rarity")
	List<Augmentation_Implant> getAllByRarity(@Param("rarity") Rarity rarity);

	@Query("select i from Augmentation_Implant i where i.name = :name")
	List<Augmentation_Implant> getAllByName(@Param("name") String name);

	@Query("select i from Augmentation_Implant i where i.type = :augmType")
	List<Augmentation_Implant> getAllByType(@Param("augmType") AugmImplType type);

	@Query("select i from Augmentation_Implant i where i.usageType = :usageType")
	List<Augmentation_Implant> getAllByUsageType(@Param("usageType") AugmImplUsageType usageType);
}
