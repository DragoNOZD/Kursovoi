package ru.trapeznikov.database.gametopurchaselink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameToPurchaseLinkServiceImpl implements GameToPurchaseLinkService {

    private GameToPurchaseLinkRepo linkRepo;

    @Autowired
    public GameToPurchaseLinkServiceImpl(GameToPurchaseLinkRepo linkRepo) {
        this.linkRepo = linkRepo;
    }

    public GameToPurchaseLinkRepo getLinkRepo() {
        return linkRepo;
    }

    public void setLinkRepo(GameToPurchaseLinkRepo linkRepo) {
        this.linkRepo = linkRepo;
    }

    @Override
    public void addLink(GameToPurchaseLink link) {
        linkRepo.saveAndFlush(link);
    }

    @Override
    public GameToPurchaseLink getByGameName(String userLogin, String name) {
        return linkRepo.findByGameName(userLogin, name);
    }

    @Override
    public List<GameToPurchaseLink> getAllByUserLogin(String userLogin) {
        return linkRepo.findAllByLogin(userLogin);
    }
}
