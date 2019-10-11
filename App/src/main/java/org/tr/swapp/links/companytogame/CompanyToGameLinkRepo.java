package org.tr.swapp.links.companytogame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tr.swapp.links.companytogame.CompanyToGameLink;

public interface CompanyToGameLinkRepo extends JpaRepository<CompanyToGameLink, Long> {
}
