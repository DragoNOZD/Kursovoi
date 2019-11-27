package ru.mmo.database.item.usable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;

import java.util.List;

public interface UsableRepository extends JpaRepository<Usable, Long> {

	@Query("SELECT i from Usable i where i.rarity = :rarity")
	List<Usable> getAllByRarity(@Param("rarity") Rarity rarity);

	@Query("select i from Usable i where i.name = :name")
	List<Usable> getAllByName(@Param("name") String name);

	@Query("select i from Usable i where i.item = :itemT")
	List<Usable> getAllByItem(@Param("itemT") UsableItemType itemType);
}
