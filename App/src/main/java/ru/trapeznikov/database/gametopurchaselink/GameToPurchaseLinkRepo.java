package ru.trapeznikov.database.gametopurchaselink;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameToPurchaseLinkRepo extends JpaRepository<GameToPurchaseLink, String> {

    @Query("SELECT l from GameToPurchaseLink l where l.game.name = :gameName and l.purchase.buyer.login = :userLogin")
    GameToPurchaseLink findByGameName(@Param("userLogin") String userLogin, @Param("gameName") String gameName);

    @Query("select l from GameToPurchaseLink l where l.purchase.buyer.login = :login")
    List<GameToPurchaseLink> findAllByLogin(@Param("login") String login);
}
