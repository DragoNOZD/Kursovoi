package org.tr.swapp.game;

import org.tr.swapp.Genre;

import javax.persistence.*;

@Entity
@Table(name = "Game")
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
}
