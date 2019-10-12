package ru.trapeznikov.database.links.gametopurchase;

import ru.trapeznikov.database.game.Game;
import ru.trapeznikov.database.purchase.Purchase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "game_to_purchase")
public class GameToPurchaseLink {

    @Id
    @Column(name = "ActivationCode")
    private String gameActivationCode;

    @Column(nullable = false)
    private Game game;

    // TODO: Add search by purchase

    @Column
    private Purchase purchase;

    public GameToPurchaseLink() {
    }

    public GameToPurchaseLink(String gameActivationCode, Game game) {
        this.gameActivationCode = gameActivationCode;
        this.game = game;
    }

    public String getGameActivationCode() {
        return gameActivationCode;
    }

    public Game getGame() {
        return game;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
