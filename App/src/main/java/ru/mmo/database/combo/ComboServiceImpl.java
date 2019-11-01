package ru.mmo.database.combo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mmo.database.melee.Melee;

import java.util.List;

@Service
public class ComboServiceImpl implements ComboService {

    private ComboRepository repository;

    @Autowired
    public ComboServiceImpl(ComboRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addCombo(Combo combo) {
        repository.saveAndFlush(combo);
    }

    @Override
    public void deleteCombo(Combo combo) {
        repository.delete(combo);
    }

    @Override
    public void updateCombo(Combo combo) {
        addCombo(combo);
    }

    @Override
    public Combo getCombo(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Combo> getAllByWepon(Melee melee) {
        return repository.getAllByWeapon(melee);
    }

    @Override
    public List<Combo> getAll() {
        return repository.findAll();
    }
}
