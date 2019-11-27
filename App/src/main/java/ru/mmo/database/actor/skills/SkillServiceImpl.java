package ru.mmo.database.actor.skills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

	private SkillRepository repository;

	@Autowired
	public SkillServiceImpl(SkillRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addSkill(Skill skill) {
		repository.saveAndFlush(skill);
	}

	@Override
	public void deleteSkill(Skill skill) {
		repository.delete(skill);
	}

	@Override
	public void updateSkill(Skill skill) {
		addSkill(skill);
	}

	@Override
	public Skill getSkill(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Skill> getAll() {
		return repository.findAll();
	}
}
