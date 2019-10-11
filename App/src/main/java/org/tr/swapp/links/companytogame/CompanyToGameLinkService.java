package org.tr.swapp.links.companytogame;

import java.util.List;

public interface CompanyToGameLinkService {
    void addLink(CompanyToGameLink link);
    void deleteLink(Long id);
    CompanyToGameLink getById(Long id);
    List<CompanyToGameLink> getAll();
}
