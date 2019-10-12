package ru.trapeznikov.database.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.trapeznikov.database.game.Game;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    @Query("SELECT r from review where game = :game and reviewer.login = :userLogin")
    Review getByLogin(@Param("userLogin") String login, @Param("game") Game game);

    @Query("select r from review where game = :game")
    List<Review> getAllByGame(@Param("game") Game game);

    @Query("select r from review where game = :game and recommendation = :recommendation")
    List<Review> getAllByRecommendation(@Param("recommendation") ReviewRecommendation recommendation, Game game);
}
