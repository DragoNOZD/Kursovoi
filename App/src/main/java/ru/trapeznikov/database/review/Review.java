package ru.trapeznikov.database.review;

import ru.trapeznikov.database.game.Game;
import ru.trapeznikov.database.user.User;

import javax.persistence.*;

@Entity
@Table
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @ManyToOne
    private Game game;

    //@Column
    //private Calendar date;

    @ManyToOne
    private User reviewer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewRecommendation recommendation;

    public Review() {
    }

    public Review(Game game, User reviewer, ReviewRecommendation recommendation) {
        this.game = game;
        this.reviewer = reviewer;
        this.recommendation = recommendation;
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

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public ReviewRecommendation getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(ReviewRecommendation recommendation) {
        this.recommendation = recommendation;
    }
}
