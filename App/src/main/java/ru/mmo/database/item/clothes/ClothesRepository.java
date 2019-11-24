package ru.mmo.database.item.clothes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;

import java.util.List;

public interface ClothesRepository extends JpaRepository<Clothes, Long> {

	@Query("SELECT i from Clothes i where i.rarity = :rarity")
	List<Clothes> getAllByRarity(@Param("rarity") Rarity rarity);

	@Query("select i from Clothes i where i.name = :name")
	List<Clothes> getAllByName(@Param("name") String name);

	@Query("select i from Clothes i where i.type = :clothesType")
	List<Clothes> getAllByType(@Param("clothesType") ClothesType type);

	@Query("select i from Clothes i where i.damageReduction >= :minReduction and i.damageReduction <= :maxReduction")
	List<Clothes> getAllByDamageReductionBetween(@Param("minReduction") double min, @Param("maxReduction") double max);
}
