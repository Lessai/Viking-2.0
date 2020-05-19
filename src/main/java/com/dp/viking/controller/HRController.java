package com.dp.viking.controller;

import com.dp.viking.domain.employee.Employee;
import com.dp.viking.domain.util.EmployeeUtil;
import com.dp.viking.service.DocxService;
import com.dp.viking.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;

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
            @RequestParam(required = false, defaultValue = "Все") String departmentFilter,
            @RequestParam(required = false, defaultValue = "Все") String categoryFilter,
            @RequestParam(required = false, defaultValue = "Имя") String filterFirstName,
            @RequestParam(required = false, defaultValue = "Фамилия") String filterLastName,
            Model model){
        if (!departmentFilter.equals("Все")
                || !categoryFilter.equals("Все")
                || !filterFirstName.equals("Имя")
                || !filterLastName.equals("Фамилия"))
        {
            model.addAttribute("employees", hrService.findEmployeesByFilter(departmentFilter, categoryFilter, filterFirstName, filterLastName));
        }
        else{
            model.addAttribute("employees", hrService.findAllEmployees());
        }
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
    public String addEmployee(@RequestParam(required = false) String department,
                              @RequestParam(value = "dateIn", required = false)
                                  @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateIn,
                              @RequestParam(required = false)  String firstName,
                              @RequestParam(required = false)  String title,
                              @RequestParam(required = false)  String secondName,
                              @RequestParam(required = false)  String maritalStatus,
                              @RequestParam(required = false)  String workMode,
                              @RequestParam(value = "birthDate", required = false)
                                  @DateTimeFormat(pattern = "yyyy-mm-dd") Date birthDate,
                              @RequestParam(required = false)  String gender,
                              @RequestParam(required = false)  String categoryName,
                              @RequestParam(required = false) boolean isContract,
                              Model model
                              ) throws IOException {
        EmployeeUtil employeeUtil = new EmployeeUtil();
        if (hrService.addEmployee(hrService.nextTabN(), department,dateIn,firstName,title,secondName, workMode, birthDate, gender, maritalStatus,categoryName)
        ){
            if (isContract) {
                docxService.createEmploymentContractDoc(department, dateIn, firstName, secondName, title, categoryName);
            }
            employeeUtil.successResult(model);
        }
        else {
            employeeUtil.failureResult(model);
        }
        return "addEmployeeResult";
    }

   /*--------------------Edit Employee--------------------*/
    @GetMapping("employees/{personTabN}/edit")
    public String editEmployee(
            @PathVariable Integer personTabN,
            Model model
    ){
        model.addAttribute("employee", hrService.findEmployeeByTabN(personTabN));
        model.addAttribute("departments", hrService.findAllDepartments());
        model.addAttribute("genders", hrService.findAllGenders());
        model.addAttribute("categories", hrService.findAllCategories());
        model.addAttribute("workmodes", hrService.findAllWorkModes());
        model.addAttribute("titles", hrService.findAllTitles());
        model.addAttribute("maritalstatuses", hrService.findAllMaritalStatuses());
        return "editEmployee";
    }

    @PostMapping("/editEmployee")
    public  String updateEmployee(
            @RequestParam(required = true) Integer tabNHidden,
            @RequestParam(required = false) String department,
            @RequestParam(value = "dateIn", required = false)
            @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateIn,
            @RequestParam(required = false)  String firstName,
            @RequestParam(required = false)  String title,
            @RequestParam(required = false)  String secondName,
            @RequestParam(required = false)  String maritalStatus,
            @RequestParam(required = false)  String workMode,
            @RequestParam(value = "birthDate", required = false)
            @DateTimeFormat(pattern = "yyyy-mm-dd") Date birthDate,
            @RequestParam(required = false)  String gender,
            @RequestParam(required = false)  String categoryName,
            Model model
    ){
        EmployeeUtil employeeUtil = new EmployeeUtil();
        if (hrService.editEmployee(tabNHidden, department,dateIn,firstName,title,secondName, workMode, birthDate, gender, maritalStatus,categoryName)
        ){
            employeeUtil.successResult(model);
        }
        else {
            employeeUtil.failureResult(model);
        }
        return "addEmployeeResult";
    }

    /*--------------------Dismiss Employee--------------------*/
    @GetMapping("employees/{personTabN}/dismiss")
    public String dismissEmployee(
            @PathVariable Integer personTabN,
            Model model
    ){
        model.addAttribute("employee", hrService.findEmployeeByTabN(personTabN));
        model.addAttribute("departments", hrService.findAllDepartments());
        model.addAttribute("categories", hrService.findAllCategories());
        model.addAttribute("titles", hrService.findAllTitles());
        return "dismissalEmployee";
    }

    @PostMapping("/dismissEmployee")
    public  String dismissEmployee(
            @RequestParam(required = true) Integer tabNHidden,
            @RequestParam(value = "dateOut", required = true)
                @DateTimeFormat(pattern = "yyyy-mm-dd") Date dateOut,
            @RequestParam(required = true)  String dismissionReason,
            @RequestParam(required = true) Boolean isOrder,
            Model model
    ) throws IOException {
        EmployeeUtil employeeUtil = new EmployeeUtil();
        Employee employee = hrService.findEmployeeByTabN(tabNHidden);
        if (hrService.dismissEmployee(tabNHidden, dateOut, dismissionReason)
        ){
            if (isOrder) {
                docxService.createDismissalOrderDoc(dateOut, employee.getPersonDateIN(), employee.getPersonFirstName(), employee.getPersonLastName(), employee.getTitle().getTitleName(), dismissionReason);
            }
            employeeUtil.successResult(model);
        }
        else {
            employeeUtil.failureResult(model);
        }
        return "addEmployeeResult";
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
