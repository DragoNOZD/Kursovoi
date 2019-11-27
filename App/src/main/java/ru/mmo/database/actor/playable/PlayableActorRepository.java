package ru.mmo.database.actor.playable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayableActorRepository extends JpaRepository<PlayableActor, Long> {

    @Query("SELECT a from PlayableActor a where a.owner.login = :owner")
    List<PlayableActor> getAllByOwner(@Param("owner") String ownerLogin);

    @Query("select a from PlayableActor a where a.name = :name")
    List<PlayableActor> getAllByName(@Param("name") String actorName);

}
