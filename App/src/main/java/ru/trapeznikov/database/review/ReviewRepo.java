package ru.trapeznikov.database.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.trapeznikov.database.game.Game;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    @Query("SELECT r from Review r where r.game = :game and r.reviewer.login = :userLogin")
    Review getByLogin(@Param("userLogin") String login, @Param("game") Game game);

    @Query("select r from Review r where r.game = :game")
    List<Review> getAllByGame(@Param("game") Game game);

    @Query("select r from Review r where r.game = :game and r.recommendation = :recommendation")
    List<Review> getAllByRecommendation(@Param("recommendation") ReviewRecommendation recommendation,
                                        @Param("game") Game game);
}
