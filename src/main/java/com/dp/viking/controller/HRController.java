package com.dp.viking.controller;

import com.dp.viking.domain.location.Street;
import com.dp.viking.service.DocxService;
import com.dp.viking.service.HRService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('HR')")
@RequestMapping("/HR")
public class HRController {
    @Autowired
    private HRService hrService;

    @Autowired
    private DocxService docxService;

    @GetMapping("employees")
    public String employeeList(
            Model model){
        model.addAttribute("employees", hrService.findAllEmployees());
        model.addAttribute("departments", hrService.findAllDepartments());
        model.addAttribute("genders", hrService.findAllGenders());
        model.addAttribute("categories", hrService.findAllCategories());
        model.addAttribute("workmodes", hrService.findAllWorkModes());
        model.addAttribute("titles", hrService.findAllTitles());
        model.addAttribute("maritalstatuses", hrService.findAllMaritalStatuses());
        model.addAttribute("tabN", hrService.nextTabN());
        return "employeesList";
    }

    @PostMapping("addEmployee")
    public String addEmployee(@RequestParam String department,
                              @RequestParam("dateIn")
                                  @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateIn,
                              @RequestParam String firstName,
                              @RequestParam String title,
                              @RequestParam String secondName,
                              @RequestParam String maritalStatus,
                              @RequestParam String workMode,
                              @RequestParam("birthDate")
                                  @DateTimeFormat(pattern = "yyyy-mm-dd") Date birthDate,
                              @RequestParam String gender,
                              @RequestParam String categoryName,
                              Model model
                              ) throws IOException {
        if (hrService.addEmployee(hrService.nextTabN(), department,dateIn,firstName,title,secondName, workMode, birthDate, gender, maritalStatus,categoryName)){
            docxService.createEmploymentContractDoc();
        }
        else {
            model.addAttribute("errorMessage", "Форма была заполнена некорректно, попробуйте еще раз.");
        }
        return "redirect:/HR/employees";
    }

    /************************   DEPARTMENTS   ***************************/
    @GetMapping("departments")
    public String departmentList(Model model){
        model.addAttribute("departments", hrService.findAllDepartments());
        model.addAttribute("employees", hrService.findAllEmployees());
        model.addAttribute("addresses", hrService.findAllAddresses());
        return "departmentsList";
    }

    @PostMapping("addDepartment")
    public String addDepartment(
            @RequestParam String departmentCode,
            @RequestParam String departmentName,
            @RequestParam String managerName,
            @RequestParam String departmentAddress){
        hrService.addDepartment(departmentCode, departmentName, managerName, departmentAddress);
        return "redirect:/HR/departments";
    }

    /************************   GET ALL ADDRESSES   ***************************/
    @GetMapping("updateAddress")
    public String addressesList(Model model){
        model.addAttribute("regions", hrService.findAllRegions());
        model.addAttribute("atdTypes", hrService.findAllATDTypes());
        model.addAttribute("countries", hrService.findAllCountries());
        model.addAttribute("localRegions", hrService.findAllLocalRegions());
        model.addAttribute("cities", hrService.findAllCities());
        model.addAttribute("streets", hrService.findAllStreets());
        model.addAttribute("streetsName", hrService.findAllStreetsNames());
        return "addressesList";
    }

    /************************   REGION   ***************************/
    @PostMapping("addRegion")
    public String addRegion(@RequestParam String regionName){
        hrService.addRegion(regionName);
        return "redirect:/HR/updateAddress";
    }
    /************************   LOCAL REGION   ***************************/
    @PostMapping("addLocalRegion")
    public String addLocalRegion(@RequestParam Integer localRegionCode,
                                    @RequestParam String localRegionName,
                                    @RequestParam String countryName,
                                    @RequestParam String atdTypeName){
        hrService.addLocalRegion(localRegionCode, localRegionName,countryName,atdTypeName);
        return "redirect:/HR/updateAddress";
    }
    /************************   ATD   ***************************/
    @PostMapping("addAtd")
    public String addATD(@RequestParam String atdTypeName, @RequestParam String atdTypeSName){
        hrService.addATDType(atdTypeName, atdTypeSName);
        return "redirect:/HR/updateAddress";

    }

    /************************   COUNTRY   ***************************/
    @PostMapping("addCountry")
    public String addCountry(@RequestParam String countryCode,
                                @RequestParam String countryName,
                                @RequestParam String regionName)
    {
        hrService.addCountry(countryCode, countryName, regionName);
        return "redirect:/HR/updateAddress";
    }
    /************************   CITY   ***************************/
    @PostMapping("addCity")
    public String updateCity(@RequestParam Short cityCode,
                             @RequestParam String cityName,
                             @RequestParam String localRegionName,
                             @RequestParam String atdTypeName)
    {
        hrService.addCity(cityCode, cityName, localRegionName, atdTypeName);
        return "redirect:/HR/updateAddress";
    }
    /************************   Street   ***************************/
    @PostMapping("addStreet")
    public String addStreet(@RequestParam String streetName,
                             @RequestParam String cityName,
                             @RequestParam String atdTypeName)
    {
        hrService.addStreet(streetName, cityName, atdTypeName);
        return "redirect:/HR/updateAddress";
    }

}
