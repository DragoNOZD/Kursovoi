package ru.mmo.database.quest.questparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestPartServiceImpl implements QuestPartService {

    private QuestPartRepository repository;

    @Autowired
    public QuestPartServiceImpl(QuestPartRepository repository) {
        this.repository = repository;
    }

    @Override
    public void addQuestPart(QuestPart part) {
        repository.saveAndFlush(part);
    }

    @Override
    public void deleteQuestPart(QuestPart part) {
        repository.delete(part);
    }

    @Override
    public void updateQuestPart(QuestPart part) {
        addQuestPart(part);
    }

    @Override
    public QuestPart getPart(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<QuestPart> getAll() {
        return repository.findAll();
    }
}
