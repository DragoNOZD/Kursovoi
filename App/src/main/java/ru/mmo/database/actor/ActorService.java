package ru.mmo.database.actor;

import java.util.List;

public interface ActorService {
    void addCharacter(Actor actor);
    void deleteCharater(Actor actor);
    Actor getCharaterById(Long id);
    List<Actor> getCharatersByName(String name);
    void updateCharacter(Actor actor);
    List<Actor> getAll();
}
