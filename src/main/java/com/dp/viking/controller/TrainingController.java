package com.dp.viking.controller;

import com.dp.viking.domain.TrainingRating;
import com.dp.viking.domain.User;
import com.dp.viking.domain.dto.TrainingDto;
import com.dp.viking.domain.dto.TrainingForecastDto;
import com.dp.viking.domain.dto.TrainingInfoDto;
import com.dp.viking.repos.TrainingRatingRepo;
import com.dp.viking.repos.TrainingRepo;
import com.dp.viking.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingRepo trainingRepo;

    @Autowired
    private TrainingRatingRepo trainingRatingRepo;

    @GetMapping
    public String trainings(
            @RequestParam(required = false, defaultValue = "") String skillFilter,
            Model model,
            @PageableDefault(sort = { "trainingID" }, direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal User user
    ) {
        Page<TrainingDto> page = trainingService.trainingList(pageable, skillFilter, user);

        model.addAttribute("page", page);
        model.addAttribute("url", "/trainings");
        model.addAttribute("skillFilter", skillFilter);
        model.addAttribute("myTrainings", false);
        return "trainings";
    }

    @GetMapping("/myTrainings")
    public String myTrainings(
            @RequestParam(required = false, defaultValue = "") String skillFilter,
            Model model,
            @PageableDefault(sort = { "trainingID" }, direction = Sort.Direction.DESC) Pageable pageable,
            @AuthenticationPrincipal User user
    ) {
        Page<TrainingDto> page = trainingService.myTrainingsList(pageable, skillFilter, user);

        model.addAttribute("page", page);
        model.addAttribute("url", "/trainings");
        model.addAttribute("skillFilter", skillFilter);
        model.addAttribute("myTrainings", true);
        return "trainings";
    }

    @GetMapping("/trainingsForecast")
    public String trainingsForecast(Model model){
        Set<TrainingInfoDto> trainingsInfo = trainingRepo.findAllForecasts();
        Long totalNrOfRegistreg = trainingRepo.totalNrOfRegistreg();

        List<TrainingInfoDto> trainingsInfoLists = new ArrayList<TrainingInfoDto>(trainingsInfo);
        List<TrainingForecastDto> trainingsForecasts = new ArrayList<TrainingForecastDto>();

        for (TrainingInfoDto trainingsInfoList : trainingsInfoLists) {
            Integer elementIdx = trainingsInfoLists.indexOf(trainingsInfoList);
            TrainingForecastDto ForecastElement = new TrainingForecastDto(trainingsInfoList.getTrainingSkill(),
                    trainingService.findLRange(trainingsForecasts, elementIdx),
                    trainingService.findURange( trainingsInfoLists, trainingsForecasts, totalNrOfRegistreg, elementIdx),
                    0,
                    0.0,
                    trainingsInfoList.getAvgPrice());
            trainingsForecasts.add(ForecastElement);
        }
        for (int i = 1; i <= 10000; i++) {
            double rnd = Math.random();
            trainingService.updateForecast(trainingsForecasts,rnd);
        }
        Double totalCost = 0.0;
        for (TrainingForecastDto trainingsForecast : trainingsForecasts) {
            totalCost += trainingsForecast.getTotalCost();
        }
        model.addAttribute("totalCost",totalCost);
        model.addAttribute("avgCost",totalCost/10000);
        model.addAttribute("trainingForecasts",trainingsForecasts);
        return "trainingsForecast";
    }


    @GetMapping("/{trainingId}/register")
    public String register(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long trainingId,
            RedirectAttributes redirectAttributes,
            @RequestHeader(required = false) String referer //current page
    ){
        Set<User> registers = trainingRepo.findByTrainingID(trainingId).getRegister();
        if(registers.contains(currentUser)){
            registers.remove(currentUser);
        }else{
            registers.add(currentUser);
        }
        //Take parameters from current page
        UriComponents components = UriComponentsBuilder.fromHttpUrl(referer).build();
        components.getQueryParams()
                .entrySet()
                .forEach(pair -> redirectAttributes.addAttribute(pair.getKey(),pair.getValue()));
        return "redirect:"+ components.getPath();
    }

    @GetMapping("/{trainingID}/{rating}/rate")
    public String setRating(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long trainingID,
            @PathVariable Short rating,
            RedirectAttributes redirectAttributes,
            @RequestHeader(required = false) String referer //current page
    ){
        TrainingRating trainingRating = trainingRatingRepo.findByTrainingAndUser(trainingRepo.findByTrainingID(trainingID), currentUser);
        trainingRatingRepo.setRating(trainingRating, rating);
        //Take parameters from current page
        UriComponents components = UriComponentsBuilder.fromHttpUrl(referer).build();
        components.getQueryParams()
                .entrySet()
                .forEach(pair -> redirectAttributes.addAttribute(pair.getKey(),pair.getValue()));
        return "redirect:"+ components.getPath();
    }

}
