package ru.mmo.database.item.weapon.ranged.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.item.Rarity;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

	private DeviceRepository repository;

	@Autowired
	public DeviceServiceImpl(DeviceRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addDevice(Device device) {
		repository.saveAndFlush(device);
	}

	@Override
	public void deleteDevice(Device device) {
		repository.delete(device);
	}

	@Override
	public void updateDevice(Device device) {
		addDevice(device);
	}

	@Override
	public Device getDevice(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Device> getAll() {
		return repository.findAll();
	}

	@Override
	public List<Device> getAllByName(String name) {
		return repository.getAllByName(name);
	}

	@Override
	public List<Device> getAllByRarity(Rarity rarity) {
		return repository.getAllByRarity(rarity);
	}

	@Override
	public List<Device> getAllByType(DeviceType type) {
		return repository.getAllByType(type);
	}
}
