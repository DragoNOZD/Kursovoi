package ru.mmo.database.item.weapon.ranged.device;

import ru.mmo.database.item.Rarity;

import java.util.List;

public interface DeviceService {
	void addDevice(Device device);
	void deleteDevice(Device device);
	void updateDevice(Device device);
	Device getDevice(Long id);
	List<Device> getAll();
	List<Device> getAllByName(String name);
	List<Device> getAllByRarity(Rarity rarity);
	List<Device> getAllByType(DeviceType type);
}
