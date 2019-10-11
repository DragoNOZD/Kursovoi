package org.tr.swapp.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tr.swapp.game.Game;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepo reviewRepo;

    @Autowired
    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    public ReviewRepo getReviewRepo() {
        return reviewRepo;
    }

    public void setReviewRepo(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public void addReview(Review review) {
        reviewRepo.saveAndFlush(review);
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepo.delete(id);
    }

    @Override
    public Review getReviewByLogin(String login, Game game) {
        return reviewRepo.getByLogin(login, game);
    }

    @Override
    public List<Review> getAllByGame(Game game) {
        return reviewRepo.getAllByGame(game);
    }

    @Override
    public List<Review> getAllByRecommendation(ReviewRecommendation recommendation, Game game) {
        return reviewRepo.getAllByRecommendation(recommendation, game);
    }
}
