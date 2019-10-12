package ru.trapeznikov.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trapeznikov.database.game.Game;
import ru.trapeznikov.database.game.GameService;

@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "NewGame")
    public String newGame(Model model){
        return "games/newGame";
    }

    @RequestMapping(value = "NewGameCheck", method = RequestMethod.POST)
    public String newGameCheck(Model model, @RequestParam("name") String name, @RequestParam("cost") float cost){
        gameService.addGame(new Game(name, cost));
        return "redirect:/";
    }

    @RequestMapping(value = "games")
    public String games(Model model){
        return "games/games";
    }

    @RequestMapping(value = "games/{id}")
    public String game(Model model, @PathVariable Long id){
        return "games/game";
    }
}
