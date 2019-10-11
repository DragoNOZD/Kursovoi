package org.tr.swapp.links.gametopurchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameToPurchaseLinkRepo extends JpaRepository<GameToPurchaseLink, String> {

    @Query("SELECT l from game_to_purchase where game.name = :gameName and purchase.buyer.login = :userLogin")
    GameToPurchaseLink findByGameName(@Param("userLogin") String userLogin, @Param("gameName") String gameName);

    @Query("select l from game_to_purchase where purchase.buyer.login = :login")
    List<GameToPurchaseLink> findAllByLogin(@Param("login") String login);
}
