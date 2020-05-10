package com.dp.viking.service;

import com.dp.viking.domain.User;
import com.dp.viking.domain.dto.TrainingDto;
import com.dp.viking.domain.dto.TrainingForecastDto;
import com.dp.viking.domain.dto.TrainingInfoDto;
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

    public Double findLRange(List<TrainingForecastDto> trainingsForecasts,
                             Integer elementIdx){
        if (elementIdx == 0){return 0.0;}
        else{return trainingsForecasts.get(elementIdx-1).getuRange();}
    }

    public Double findURange(List<TrainingInfoDto> trainingsInfoLists,
                             List<TrainingForecastDto> trainingsForecasts,
                             Long totalNrOfRegistreg,
                             Integer elementIdx){
        if (elementIdx == 0){return trainingsInfoLists.get(elementIdx).getNrOfRegistred()/totalNrOfRegistreg.doubleValue();}
        else{return trainingsForecasts.get(elementIdx-1).getuRange() + trainingsInfoLists.get(elementIdx).getNrOfRegistred()/totalNrOfRegistreg.doubleValue();}
    }

    public Boolean findCurrent(TrainingForecastDto trainingsForecast, Double rnd){
        if (trainingsForecast.getlRange()<=rnd && trainingsForecast.getuRange()>rnd) {
            return true;
        }
        else return false;
    }

    public void updateForecast(List<TrainingForecastDto> trainingsForecasts,Double rnd){
        for (TrainingForecastDto trainingsForecast : trainingsForecasts) {
            if(findCurrent(trainingsForecast, rnd)){
                TrainingForecastDto currentForecast = trainingsForecast;
                TrainingForecastDto updatedForecast = new TrainingForecastDto(
                        currentForecast.getTrainingSkill(),
                        currentForecast.getlRange(),
                        currentForecast.getuRange(),
                        currentForecast.getRegistrationQty()+1,
                        currentForecast.getTotalCost()+currentForecast.getAvgPrice(),
                        currentForecast.getAvgPrice());
                updatedForecast.setAvgCost(updatedForecast.getTotalCost()/10000);
                updatedForecast.setTotalCostK(updatedForecast.getTotalCost()/1000);
                updatedForecast.setRegistrationPerc(updatedForecast.getRegistrationQty().doubleValue()/10000);
                trainingsForecasts.remove(trainingsForecast);
                trainingsForecasts.add(updatedForecast);
                break;
            }
        }
    }
}
