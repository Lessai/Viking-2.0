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
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    @GetMapping("updateDepartment")
    public String departmentList(Model model){
        model.addAttribute("departments", adminService.findAllDepartments());
        return "departmentsList";
    }

}
