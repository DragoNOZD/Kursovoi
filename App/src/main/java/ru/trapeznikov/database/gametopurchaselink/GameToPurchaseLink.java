package ru.trapeznikov.database.gametopurchaselink;

import ru.trapeznikov.database.game.Game;
import ru.trapeznikov.database.purchase.Purchase;
import ru.trapeznikov.database.user.User;

import javax.persistence.*;

@Entity
@Table(name = "game_to_purchase")
public class GameToPurchaseLink {

    @Id
    @Column(name = "ActivationCode")
    private String gameActivationCode;

    @ManyToOne
    private Game game;

    // TODO: Add search by purchase

    @ManyToOne(fetch = FetchType.LAZY)
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
