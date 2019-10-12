package ru.trapeznikov.database.company;

import ru.trapeznikov.database.Country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.net.URL;
import java.sql.Date;

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
}
