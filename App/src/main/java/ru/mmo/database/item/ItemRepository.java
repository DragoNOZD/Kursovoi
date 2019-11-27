package ru.mmo.database.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i from Item i where i.rarity = :rarity")
    List<Item> getAllByRarity(@Param("rarity") Rarity rarity);

    @Query("select i from Item i where i.name = :name")
    List<Item> getAllByName(@Param("name") String name);
}
