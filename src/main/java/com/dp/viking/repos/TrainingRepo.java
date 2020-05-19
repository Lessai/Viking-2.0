package com.dp.viking.repos;

import com.dp.viking.domain.Training;
import com.dp.viking.domain.User;
import com.dp.viking.domain.dto.TrainingDto;
import com.dp.viking.domain.dto.TrainingInfoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Set;

public interface TrainingRepo extends JpaRepository<Training, Integer> {

    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0, " +
            "   count(tr) >= t.trainingCapacity, " +
            "   CURRENT_TIMESTAMP >= t.trainingEndDate, " +
            "   cast(1 AS short) " +
            ") " +
            "from Training t left join t.register tr " +
            "where t.trainingSkill = :trainingSkill " +
            "and t.trainingStartDt >= CURRENT_TIMESTAMP " +
            "group by t")
    Page<TrainingDto> findBySkill(@Param("trainingSkill") String skill, Pageable pageable, @Param("user") User user);

    Training findByTrainingID(Long trainingId);

    Training findByTrainingName(String trainingName);


    @Query("select new com.dp.viking.domain.dto.TrainingInfoDto(" +
            "   t.trainingSkill, " +
            "   count(tr), " +
            "   avg(t.trainingPrice) " +
            ") " +
            "from Training t left join t.register tr " +
            "group by t.trainingSkill")
    Set<TrainingInfoDto> findAllForecasts();

    @Query("select count(tr) from Training t join t.register tr")
    Long totalNrOfRegistreg();

    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0, " +
            "   count(tr) >= t.trainingCapacity, " +
            "   CURRENT_TIMESTAMP >= t.trainingEndDate, " +
            "   cast(1 AS short) " +
            ") " +
            "from Training t left join t.register tr " +
            "where t.trainingStartDt >= CURRENT_TIMESTAMP " +
            "group by t")
    Page<TrainingDto> findAll(Pageable pageable, @Param("user") User user);

    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0, " +
            "   count(tr) >= t.trainingCapacity, " +
            "   CURRENT_TIMESTAMP >= t.trainingEndDate, " +
            "   cast(sum(trat.rating) as short)" +
            ") " +
            "from Training t left join t.register tr left join t.trainingRatings trat " +
            "where trat.user = :user " +
            "group by t " +
            "having sum(case when tr = :user then 1 else 0 end) > 0")
    Page<TrainingDto> findAllMy(Pageable pageable, @Param("user") User user);


    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0, " +
            "   count(tr) >= t.trainingCapacity ," +
            "   CURRENT_TIMESTAMP >= t.trainingEndDate, " +
            "   cast(1 AS short) " +
            ") " +
            "from Training t left join t.register tr " +
            "where t.trainingSkill = :trainingSkill " +
            "group by t " +
            "having sum(case when tr = :user then 1 else 0 end) > 0")
    Page<TrainingDto> findMyBySkill(@Param("trainingSkill") String skill, Pageable pageable, @Param("user") User user);


}
