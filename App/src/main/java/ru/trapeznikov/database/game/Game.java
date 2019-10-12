package ru.trapeznikov.database.game;

import ru.trapeznikov.database.Genre;
import ru.trapeznikov.database.companytogamelink.CompanyToGameLink;
import ru.trapeznikov.database.review.Review;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game")
public class Game{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    // TODO: Add search by cost, discount and genre

    @Column(nullable = false)
    private float cost;

    @Column
    private float discount;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany
    private List<CompanyToGameLink> gameLinks;

    @Enumerated(EnumType.STRING)
    @Column
    private Genre genre = Genre.NOT_SELECTED;

    public Game() {
    }

    public Game(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost - cost*discount;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount/100;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<CompanyToGameLink> getGameLinks() {
        return gameLinks;
    }

    public void setGameLinks(List<CompanyToGameLink> gameLinks) {
        this.gameLinks = gameLinks;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
