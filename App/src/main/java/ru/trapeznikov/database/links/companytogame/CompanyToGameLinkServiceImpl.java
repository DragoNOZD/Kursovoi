package ru.trapeznikov.database.links.companytogame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyToGameLinkServiceImpl implements CompanyToGameLinkService {

    private CompanyToGameLinkRepo linkRepo;

    @Autowired
    public CompanyToGameLinkServiceImpl(CompanyToGameLinkRepo linkRepo) {
        this.linkRepo = linkRepo;
    }

    public CompanyToGameLinkRepo getLinkRepo() {
        return linkRepo;
    }

    public void setLinkRepo(CompanyToGameLinkRepo linkRepo) {
        this.linkRepo = linkRepo;
    }

    @Override
    public void addLink(CompanyToGameLink link) {
        linkRepo.saveAndFlush(link);
    }

    @Override
    public void deleteLink(Long id) {
        linkRepo.delete(id);
    }

    @Override
    public CompanyToGameLink getById(Long id) {
        return linkRepo.getOne(id);
    }

    @Override
    public List<CompanyToGameLink> getAll() {
        return linkRepo.findAll();
    }
}
