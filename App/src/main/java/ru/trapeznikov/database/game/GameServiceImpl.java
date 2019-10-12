package ru.trapeznikov.database.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepo gameRepo;

    @Autowired
    public GameServiceImpl(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public GameRepo getGameRepo() {
        return gameRepo;
    }

    public void setGameRepo(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    @Override
    public void addGame(Game game) {
        gameRepo.saveAndFlush(game);
    }

    @Override
    public void deleteGame(Long id) {
        gameRepo.delete(id);
    }

    @Override
    public Game getById(Long id) {
        return gameRepo.getOne(id);
    }

    @Override
    public Game getByName(String name) {
        return gameRepo.findByName(name);
    }

    @Override
    public List<Game> getAll() {
        return gameRepo.findAll();
    }
}
