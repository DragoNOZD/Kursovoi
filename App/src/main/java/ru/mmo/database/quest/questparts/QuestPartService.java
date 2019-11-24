package ru.mmo.database.quest.questparts;

import java.util.List;

public interface QuestPartService {
    void addQuestPart(QuestPart part);
    void deleteQuestPart(QuestPart part);
    void updateQuestPart(QuestPart part);
    QuestPart getPart(Long id);
    List<QuestPart> getAll();
}
