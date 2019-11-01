package ru.mmo.database.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private ActorRepository repository;

    @Autowired
    public ActorServiceImpl(ActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addCharacter(Actor actor) {
        repository.saveAndFlush(actor);
    }

    @Override
    public void deleteCharater(Actor actor) {
        repository.delete(actor);
    }

    @Override
    public Actor getCharaterById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Actor> getCharatersByName(String name) {
        return repository.getAllByName(name);
    }

    @Override
    public void updateCharacter(Actor actor) {
        addCharacter(actor);
    }

    @Override
    public List<Actor> getAll() {
        return repository.findAll();
    }
}
