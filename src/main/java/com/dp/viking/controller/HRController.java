package com.dp.viking.controller;

import com.dp.viking.service.AdminService;
import com.dp.viking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('HR')")
@RequestMapping("/HR")
public class HRController {

    @GetMapping("employees")
    public String employeeList(Model model){
        return "employeeList";
    }

}
