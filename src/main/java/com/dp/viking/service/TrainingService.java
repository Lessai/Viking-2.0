package com.dp.viking.service;

import com.dp.viking.domain.Training;
import com.dp.viking.domain.User;
import com.dp.viking.domain.dto.TrainingDto;
import com.dp.viking.repos.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepo trainingRepo;

    public Page<TrainingDto> trainingList(Pageable pageable, String skillFilter, User user) {
        if (skillFilter != null && !skillFilter.isEmpty()) {
            return trainingRepo.findBySkill(skillFilter, pageable, user);
        } else {
            return trainingRepo.findAll(pageable, user);
        }
    }

    public Page<TrainingDto> myTrainingsList(Pageable pageable, String skillFilter, User user) {
        if (skillFilter != null && !skillFilter.isEmpty()) {
            return trainingRepo.findMyBySkill(skillFilter, pageable, user);
        } else {
            return trainingRepo.findAllMy(pageable, user);
        }
    }

    public List<Training> findAllTrainings() {
        return trainingRepo.findAll();
    }
}
