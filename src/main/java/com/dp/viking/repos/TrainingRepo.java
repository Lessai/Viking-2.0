package com.dp.viking.repos;

import com.dp.viking.domain.Training;
import com.dp.viking.domain.User;
import com.dp.viking.domain.dto.TrainingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrainingRepo extends JpaRepository<Training, Integer> {

    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0" +
            ") " +
            "from Training t left join t.register tr " +
            "group by t")
    Page<TrainingDto> findAll(Pageable pageable, @Param("user") User user);

    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0" +
            ") " +
            "from Training t left join t.register tr " +
            "group by t " +
            "having sum(case when tr = :user then 1 else 0 end) > 0")
    Page<TrainingDto> findAllMy(Pageable pageable, @Param("user") User user);

    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0" +
            ") " +
            "from Training t left join t.register tr " +
            "where t.trainingSkill = :trainingSkill " +
            "group by t " +
            "having sum(case when tr = :user then 1 else 0 end) > 0")
    Page<TrainingDto> findMyBySkill(@Param("trainingSkill") String skill, Pageable pageable, @Param("user") User user);

    @Query("select new com.dp.viking.domain.dto.TrainingDto(" +
            "   t, " +
            "   count(tr), " +
            "   sum(case when tr = :user then 1 else 0 end) > 0" +
            ") " +
            "from Training t left join t.register tr " +
            "where t.trainingSkill = :trainingSkill " +
            "group by t")
    Page<TrainingDto> findBySkill(@Param("trainingSkill") String skill, Pageable pageable, @Param("user") User user);

    Training findByTrainingName(String trainingName);

    Training findByTrainingID(Long trainingId);
}
