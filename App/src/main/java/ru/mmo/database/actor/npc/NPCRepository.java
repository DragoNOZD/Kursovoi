package ru.mmo.database.actor.npc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NPCRepository extends JpaRepository<NPC, Long> {

	@Query("select c from NPC c where c.name = :name")
	List<NPC> getAllByName(@Param("name") String name);

}
