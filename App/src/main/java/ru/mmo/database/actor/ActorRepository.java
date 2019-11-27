package ru.mmo.database.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.actor.skills.Skill;

import java.util.List;
import java.util.Map;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("select c from Actor c where c.name = :name")
    List<Actor> getAllByName(@Param("name") String name);
}
