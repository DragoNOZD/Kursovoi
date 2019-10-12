package ru.trapeznikov.database.links.companytogame;

import java.util.List;

public interface CompanyToGameLinkService {
    void addLink(CompanyToGameLink link);
    void deleteLink(Long id);
    CompanyToGameLink getById(Long id);
    List<CompanyToGameLink> getAll();
}
