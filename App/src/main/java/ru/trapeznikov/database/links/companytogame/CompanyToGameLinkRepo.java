package ru.trapeznikov.database.links.companytogame;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyToGameLinkRepo extends JpaRepository<CompanyToGameLink, Long> {
}
