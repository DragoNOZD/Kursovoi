package ru.mmo.database.actor.skills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query("select s from Skill s where s.type = :sType")
    List<Skill> getAllByType(@Param("sType") SkillType type);
}
