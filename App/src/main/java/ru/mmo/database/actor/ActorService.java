package ru.mmo.database.actor;

import ru.mmo.database.actor.skills.Skill;

import java.util.List;
import java.util.Map;

public interface ActorService {
    void addCharacter(Actor actor);
    void deleteCharater(Actor actor);
    Actor getCharaterById(Long id);
    List<Actor> getCharatersByName(String name);
    void updateCharacter(Actor actor);
    List<Actor> getAll();
}
