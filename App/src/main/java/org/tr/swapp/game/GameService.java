package org.tr.swapp.game;

import java.util.List;

public interface GameService {
    void addGame(Game game);
    void deleteGame(Long id);
    Game getById(Long id);
    Game getByName(String name);
    List<Game> getAll();
}
