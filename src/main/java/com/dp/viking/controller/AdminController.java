package com.dp.viking.controller;

import com.dp.viking.service.AdminService;
import com.dp.viking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    /************************   USER LIST   ***************************/

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "userList";
    }

    /************************   DEPARTMENTS   ***************************/
    @GetMapping("updateDepartment")
    public String departmentList(Model model){
        model.addAttribute("departments", adminService.findAllDepartments());
        return "departmentsList";
    }

    @PostMapping("updateDepartment")
    public String updateDepartment(
            @RequestParam String departmentCode,
            @RequestParam String departmentName){
        adminService.addDepartment(departmentCode, departmentName);

        return "redirect:/admin/departmentsList";
    }

    /************************   GET ALL ADDRESSES   ***************************/
    @GetMapping("updateAddress")
    public String addressesList(Model model){
        model.addAttribute("regions", adminService.findAllRegions());
        model.addAttribute("atdTypes", adminService.findAllATDTypes());
        model.addAttribute("countries", adminService.findAllCountries());
        return "addressesList";
    }

    /************************   REGION   ***************************/
    @PostMapping("updateRegion")
    public String updateRegion(@RequestParam String regionName){
        adminService.addRegion(regionName);
     ;
        return "redirect:/admin/updateAddress";
    }

    /************************   ATD   ***************************/
    @PostMapping("updateAtd")
    public String updateATD(@RequestParam String atdTypeName, @RequestParam String atdTypeSName){
        adminService.addATDType(atdTypeName, atdTypeSName);
        return "redirect:/admin/updateAddress";

    }

    /************************   COUNTRY   ***************************/
    @PostMapping("updateCountry")
    public String updateCountry(@RequestParam String countryCode,
                                @RequestParam String countryName,
                                @RequestParam String regionName)
    {
        adminService.addCountry(countryCode, countryName, regionName);
        return "redirect:/admin/updateAddress";
    }
}
