package ru.mmo.database.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query("select c from Character c where c.name = :name")
    List<Character> getAllByName(@Param("name") String name);
}
