package com.dp.viking.controller;

import com.dp.viking.domain.Training;
import com.dp.viking.domain.User;
import com.dp.viking.domain.dto.TrainingDto;
import com.dp.viking.domain.employee.Employee;
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

import java.util.Set;

@Controller
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingRepo trainingRepo;

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

}
