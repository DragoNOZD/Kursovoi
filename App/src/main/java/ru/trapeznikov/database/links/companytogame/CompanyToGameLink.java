package ru.trapeznikov.database.links.companytogame;

import ru.trapeznikov.database.CompanyType;
import ru.trapeznikov.database.company.Company;
import ru.trapeznikov.database.game.Game;

import javax.persistence.*;

@Entity
@Table(name = "company_to_game")
public class CompanyToGameLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private Game game;

    @Column(nullable = false)
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column
    private CompanyType companyType;

    public CompanyToGameLink() {
    }

    public CompanyToGameLink(Game game, Company company, CompanyType companyType) {
        this.game = game;
        this.company = company;
        this.companyType = companyType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }
}
