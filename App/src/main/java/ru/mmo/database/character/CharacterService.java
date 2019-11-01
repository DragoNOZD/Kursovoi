package ru.mmo.database.character;

import java.util.List;

public interface CharacterService {
    void addCharacter(Character character);
    void deleteCharater(Character character);
    Character getCharaterById(Long id);
    List<Character> getCharatersByName(String name);
    void updateCharacter(Character character);
    List<Character> getAll();
}
