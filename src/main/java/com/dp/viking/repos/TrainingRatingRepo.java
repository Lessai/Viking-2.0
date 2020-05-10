package com.dp.viking.repos;

import com.dp.viking.domain.Training;
import com.dp.viking.domain.TrainingRating;
import com.dp.viking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TrainingRatingRepo extends JpaRepository<TrainingRating, Integer> {

    TrainingRating findByTrainingAndUser(Training training, User user);

    @Modifying
    @Transactional
    @Query("update TrainingRating tr set tr.rating = :rating where tr = :trainingRating")
    int setRating(@Param("trainingRating") TrainingRating trainingRating, @Param("rating") Short rating);

}
