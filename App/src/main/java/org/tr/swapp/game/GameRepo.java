package org.tr.swapp.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepo extends JpaRepository<Game, Long> {

    @Query("SELECT g from game where g.name = :name")
    Game findByName(@Param("name") String name);
}
