package org.tr.swapp.review;

import org.tr.swapp.game.Game;

import java.util.List;

public interface ReviewService {
    void addReview(Review review);
    void deleteReview(Long id);
    Review getReviewByLogin(String login, Game game);
    List<Review> getAllByGame(Game game);
    List<Review> getAllByRecommendation(ReviewRecommendation recommendation, Game game);
}
