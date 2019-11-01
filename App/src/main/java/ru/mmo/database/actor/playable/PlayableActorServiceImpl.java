package ru.mmo.database.actor.playable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayableActorServiceImpl implements PlayableActorService {

    private PlayableActorRepository repository;

    @Autowired
    public PlayableActorServiceImpl(PlayableActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addActor(PlayableActor actor) {
        repository.saveAndFlush(actor);
    }

    @Override
    public void deleteActor(PlayableActor actor) {
        repository.delete(actor);
    }

    @Override
    public void updateActor(PlayableActor actor) {
        addActor(actor);
    }

    @Override
    public PlayableActor getActorById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<PlayableActor> getAll() {
        return repository.findAll();
    }

    @Override
    public List<PlayableActor> getAllByName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public List<PlayableActor> getAllByOwner(String login) {
        return repository.getAllByOwner(login);
    }
}
