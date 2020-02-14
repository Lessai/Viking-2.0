package com.dp.viking.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @PreAuthorize("hasAuthority('ADMIN') and hasAuthority('HR')")
    @GetMapping
    public String employeeList(){
        return "employeeList";
    }
}