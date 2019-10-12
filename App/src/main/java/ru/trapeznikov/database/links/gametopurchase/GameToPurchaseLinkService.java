package ru.trapeznikov.database.links.gametopurchase;

import java.util.List;

public interface GameToPurchaseLinkService {
    void addLink(GameToPurchaseLink link);
    GameToPurchaseLink getByGameName(String userLogin, String name);
    List<GameToPurchaseLink> getAllByUserLogin(String userLogin);
}
