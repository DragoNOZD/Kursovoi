package ru.mmo.database.actor.playable;

import java.util.List;

public interface PlayableActorService {
    void addActor(PlayableActor actor);
    void deleteActor(PlayableActor actor);
    void updateActor(PlayableActor actor);
    PlayableActor getActorById(Long id);
    List<PlayableActor> getAll();
    List<PlayableActor> getAllByName(String name);
    List<PlayableActor> getAllByOwner(String login);
}
