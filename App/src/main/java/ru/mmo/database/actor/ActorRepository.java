package ru.mmo.database.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("select c from Actor c where c.name = :name")
    List<Actor> getAllByName(@Param("name") String name);
}
