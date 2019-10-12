package ru.trapeznikov.database.company;

import ru.trapeznikov.database.Country;
import ru.trapeznikov.database.companytogamelink.CompanyToGameLink;

import javax.persistence.*;
import java.net.URL;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column(nullable = false)
    private long inn;

    @Column(nullable = false)
    private String name;

    // TODO: Add search by date foundation, country and name

    @Column
    private Country country = Country.NOT_SELECTED;

    @Column
    private Date founded;

    @Column
    private URL site;

    @OneToMany
    private List<CompanyToGameLink> gameLinks;

    public Company() {
    }

    public Company(long inn, String name) {
        this.inn = inn;
        this.name = name;
    }

    public long getInn() {
        return inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getFounded() {
        return founded;
    }

    public void setFounded(Date founded) {
        this.founded = founded;
    }

    public URL getSite() {
        return site;
    }

    public void setSite(URL site) {
        this.site = site;
    }

    public List<CompanyToGameLink> getGameLinks() {
        return gameLinks;
    }

    public void setGameLinks(List<CompanyToGameLink> gameLinks) {
        this.gameLinks = gameLinks;
    }
}
