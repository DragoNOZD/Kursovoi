package ru.mmo.database.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository repository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addCharacter(Character character) {
        repository.saveAndFlush(character);
    }

    @Override
    public void deleteCharater(Character character) {
        repository.delete(character);
    }

    @Override
    public Character getCharaterById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Character> getCharatersByName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public void updateCharacter(Character character) {
        addCharacter(character);
    }

    @Override
    public List<Character> getAll() {
        return repository.findAll();
    }
}
