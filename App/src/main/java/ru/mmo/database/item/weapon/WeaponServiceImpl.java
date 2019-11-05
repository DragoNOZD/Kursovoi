package ru.mmo.database.item.weapon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponServiceImpl implements WeaponService{

    private WeaponRepository repository;

    @Autowired
    public WeaponServiceImpl(WeaponRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addWeapon(Weapon weapon) {
        repository.saveAndFlush(weapon);
    }

    @Override
    public void deleteWeapon(Weapon weapon) {
        repository.delete(weapon);
    }

    @Override
    public void updateWeapon(Weapon weapon) {
        addWeapon(weapon);
    }

    @Override
    public Weapon getWeaponById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Weapon> getAll() {
        return repository.findAll();
    }
}
