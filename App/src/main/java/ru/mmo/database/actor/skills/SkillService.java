package ru.mmo.database.actor.skills;

import java.util.List;

public interface SkillService {
	void addSkill(Skill skill);
	void deleteSkill(Skill skill);
	void updateSkill(Skill skill);
	Skill getSkill(Long id);
	List<Skill> getAll();
}
