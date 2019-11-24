package ru.mmo.database.quest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.mmo.database.actor.npc.NPC;

import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {

	@Query("select q from Quest q where q.type = :qType")
	List<Quest> getAllByType(@Param("qType") QuestType type);
}
