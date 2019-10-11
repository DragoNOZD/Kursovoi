package org.tr.swapp.links.gametopurchase;

import org.tr.swapp.user.User;

import java.util.List;

public interface GameToPurchaseLinkService {
    void addLink(GameToPurchaseLink link);
    GameToPurchaseLink getByGameName(String userLogin, String name);
    List<GameToPurchaseLink> getAllByUserLogin(String userLogin);
}
