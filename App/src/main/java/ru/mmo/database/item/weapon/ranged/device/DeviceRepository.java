package ru.mmo.database.item.weapon.ranged.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.item.Rarity;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

	@Query("SELECT i from Device i where i.rarity = :rarity")
	List<Device> getAllByRarity(@Param("rarity") Rarity rarity);

	@Query("select i from Device i where i.name = :name")
	List<Device> getAllByName(@Param("name") String name);

	@Query("select i from Device i where i.type = :deviceType")
	List<Device> getAllByType(@Param("deviceType") DeviceType type);

}
