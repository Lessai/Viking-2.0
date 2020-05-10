package com.dp.viking.service;

import com.dp.viking.domain.*;
import com.dp.viking.domain.employee.*;
import com.dp.viking.domain.location.*;
import com.dp.viking.repos.*;
import com.dp.viking.repos.employeeRepo.*;
import com.dp.viking.repos.locationRepo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HRService {
    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private LocalRegionRepo localRegionRepo;
    @Autowired
    private ATDTypeRepo atdTypeRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private StreetRepo streetRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private GenderRepo genderRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private MaritalStatusRepo maritalStatusRepo;
    @Autowired
    private TitleRepo titleRepo;
    @Autowired
    private WorkModeRepo workModeRepo;

    /************************   MARITAL   ***************************/
    public List<MaritalStatus> findAllMaritalStatuses() {
        return maritalStatusRepo.findAll();
    }

    /************************   WORKMODE   ***************************/
    public List<WorkMode> findAllWorkModes() {
        return workModeRepo.findAll();
    }

    /************************   TITLE   ***************************/
    public List<Title> findAllTitles() {
        return titleRepo.findAll();
    }

    /************************   CATEGORY   ***************************/
    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    /************************   EMPLOYEE   ***************************/
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee findEmployeeByTabN(Integer personTabN){ return employeeRepo.findByPersonTabN(personTabN); }

    public List<Employee> findEmployeesByFilter(String departmentFilter, String categoryFilter,String  filterFirstName,String filterLastName)
    {return employeeRepo.findEmployeesByFilter(departmentFilter, categoryFilter, filterFirstName, filterLastName);}

    public  Integer nextTabN(){return employeeRepo.findNextTabN();}

    public Employee findEmployeeByName(String firstAndLastName) {
        String employeeNameArray [] = firstAndLastName.split(" ");
        return employeeRepo.findByPersonFirstNameAndPersonLastName(employeeNameArray[0],employeeNameArray[1]);
    }

    public boolean addEmployee(Integer tabN,
                               String departmentName,
                               Date dateIn,
                               String firstName,
                               String title,
                               String secondName,
                               String workMode,
                               Date birthDate,
                               String gender,
                               String maritalStatus,
                               String categoryName){
        if (departmentName == null ||
                dateIn == null ||
                firstName == null ||
                title == null ||
                secondName == null ||
                birthDate == null ||
                workMode == null ||
                gender == null ||
                maritalStatus == null ||
                categoryName == null
        ) {
            return false;
        }
        Employee employee = new Employee();
        employee.setPersonTabN(tabN);
        employee.setDepartment(departmentRepo.findByDepartmentName(departmentName));
        employee.setPersonDateIN(dateIn);
        employee.setPersonFirstName(firstName);
        employee.setPersonLastName(secondName);
        employee.setTitle(titleRepo.findByTitleName(title));
        employee.setWorkMode(workModeRepo.findByWorkModeName(workMode));
        employee.setPersonBirthDate(birthDate);
        employee.setGender(genderRepo.findByGenderName(gender));
        employee.setMaritalStatus(maritalStatusRepo.findByMaritalStatusName(maritalStatus));
        employee.setCategory(categoryRepo.findByCategName(categoryName));
        employeeRepo.save(employee);
        return true;
    }

    public boolean editEmployee(Integer tabN,
                               String departmentName,
                               Date dateIn,
                               String firstName,
                               String title,
                               String secondName,
                               String workMode,
                               Date birthDate,
                               String gender,
                               String maritalStatus,
                               String categoryName){
        if (departmentName == null ||
                dateIn == null ||
                firstName == null ||
                title == null ||
                secondName == null ||
                birthDate == null ||
                workMode == null ||
                gender == null ||
                maritalStatus == null ||
                categoryName == null
        ) {
            return false;
        }
        Employee employee = employeeRepo.findByPersonTabN(tabN);
        employee.setDepartment(departmentRepo.findByDepartmentName(departmentName));
        employee.setPersonDateIN(dateIn);
        employee.setPersonFirstName(firstName);
        employee.setPersonLastName(secondName);
        employee.setTitle(titleRepo.findByTitleName(title));
        employee.setWorkMode(workModeRepo.findByWorkModeName(workMode));
        employee.setPersonBirthDate(birthDate);
        employee.setGender(genderRepo.findByGenderName(gender));
        employee.setMaritalStatus(maritalStatusRepo.findByMaritalStatusName(maritalStatus));
        employee.setCategory(categoryRepo.findByCategName(categoryName));
        employeeRepo.save(employee);
        return true;
    }

    public boolean dismissEmployee(Integer tabN,
                                Date dateOut,
                                String dismissionReason
                                ){
        if (
                dateOut == null || dismissionReason == null
        ) {
            return false;
        }
        Employee employee = employeeRepo.findByPersonTabN(tabN);
        employee.setPersonDateOut(dateOut);
        employee.setDismissalReason(dismissionReason);
        employeeRepo.save(employee);
        return true;
    }

    /************************   GENDER  ***************************/
    public List<Gender> findAllGenders() {
        return genderRepo.findAll();
    }

    /************************   DEPARTMENT   ***************************/
    public List<Department> findAllDepartments() {
        return departmentRepo.findAll();
    }

    public boolean addDepartment(String departmentCode,
                                 String departmentName,
                                 String managerFirstAndLastName,
                                 String departmentAddress) {
        Department departmentFromDb = departmentRepo.findByDepartmentName(departmentName);
        Address departAddressFromDb = addressRepo.findAddressByDepartmentAddress(departmentAddress);
        if (departmentFromDb != null ||
                departmentName == null ||
                departmentCode == null ||
                managerFirstAndLastName == null ||
                departmentAddress == null ||
                departAddressFromDb == null
        ) {
            return false;
        }

        Department department = new Department();
        department.setDepartmentName(departmentName);
        department.setDepartmentCode(departmentCode);
        department.setDepartmentManager(findEmployeeByName(managerFirstAndLastName));
        department.setAddress(addressRepo.findAddressByDepartmentAddress(departmentAddress));
        departmentRepo.save(department);
        return true;
    }

    /************************   REGION   ***************************/
    public List<Region> findAllRegions() {
        return regionRepo.findAll();
    }

    public boolean addRegion(String regionName) {
        Region regionFromDb = regionRepo.findByRegionName(regionName);

        if (regionFromDb != null) {
            return false;
        }

        Region region = new Region();
        region.setRegionName(regionName);

        regionRepo.save(region);

        return true;
    }
    /************************   LOCAL REGION   ***************************/
    public List<LocalRegion> findAllLocalRegions() {
        return localRegionRepo.findAll();
    }

    public boolean addLocalRegion(
            Integer localRegionCode,
            String localRegionName,
            String countryName,
            String atdTypeName
    ) {
        ATDType atdTypeFromDb = atdTypeRepo.findByAtdTypeName(countryName);

        LocalRegion localRegionFromDB = localRegionRepo.findByLocalRegionCodeOrLocalRegionName(localRegionCode,localRegionName);

        if (localRegionFromDB != null ) {
            return false;
        }

        LocalRegion localRegion = new LocalRegion();
        localRegion.setLocalRegionCode(localRegionCode);
        localRegion.setLocalRegionName(localRegionName);
        localRegion.setCountry(countryRepo.findByCountryName(countryName));
        localRegion.setAtdType(atdTypeRepo.findByAtdTypeName(atdTypeName));

        localRegionRepo.save(localRegion);

        return true;
    }

    /************************   ATDType   ***************************/
    public List<ATDType> findAllATDTypes() {
        return atdTypeRepo.findAll();
    }

    public boolean addATDType(String atdTypeName, String atdTypeSName) {
        ATDType atdTypeFromDb = atdTypeRepo.findByAtdTypeNameAndAtdTypeSName(atdTypeName,atdTypeSName);

        if (atdTypeFromDb != null) {
            return false;
        }

        ATDType atdType = new ATDType();
        atdType.setAtdTypeName(atdTypeName);
        atdType.setAtdTypeSName(atdTypeSName);

        atdTypeRepo.save(atdType);

        return true;
    }
    /************************   Country   ***************************/
    public List<Country> findAllCountries() {
        return countryRepo.findAll();
    }

    public boolean addCountry(String countryCode, String countryName, String regionName) {
        Country countryFromDb = countryRepo.findByCountryName(countryName);

        if (countryFromDb != null) {
            return false;
        }

        Country country = new Country();
        country.setCountryCode(countryCode);
        country.setCountryName(countryName);
        country.setRegion(regionRepo.findByRegionName(regionName));

        countryRepo.save(country);

        return true;
    }
    /************************   City   ***************************/
    public List<City> findAllCities() {
        return cityRepo.findAll();
    }

    public boolean addCity(Short cityCode, String cityName, String localRegionName, String atdTypeName) {
        City cityFromDb = cityRepo.findByCityName(cityName);

        if (cityFromDb != null) {
            return false;
        }

        City city = new City();
        city.setCityCode(cityCode);
        city.setCityName(cityName);
        city.setLocalRegion(localRegionRepo.findByLocalRegionName(localRegionName));
        city.setAtdType(atdTypeRepo.findByAtdTypeName(atdTypeName));

        cityRepo.save(city);

        return true;
    }
    /************************   Street   ***************************/
    public List<Street> findAllStreets() {
        return streetRepo.findAll();
    }
    public List<String> findAllStreetsNames() {
        List<Street> streets = streetRepo.findAll();
        return streets.stream().map(urEntity -> urEntity.getStreetName()).collect(Collectors.toList());
    }

    public boolean addStreet(String streetName, String cityName, String atdTypeName) {
        Street streetFromDb = streetRepo.findByStreetName(streetName);

        if (streetFromDb != null) {
            return false;
        }

        Street street = new Street();
        street.setStreetName(streetName);
        street.setCity(cityRepo.findByCityName(cityName));
        street.setAtdType(atdTypeRepo.findByAtdTypeName(atdTypeName));

        streetRepo.save(street);

        return true;
    }
    /************************   Address   ***************************/
    public List<Address> findAllAddresses() {
        return addressRepo.findAll();
    }

    public boolean addAddress(String building, String apartment, String streetName) {
        Street street = streetRepo.findByStreetName(streetName);
        Address addressFromDb = addressRepo.findByStreetAndBuildingAndApartment(
                street,
                building,
                apartment);

        if (addressFromDb != null) {
            return false;
        }

        Address address = new Address();
        address.setBuilding(building);
        address.setApartment(apartment);
        address.setStreet(street);

        addressRepo.save(address);

        return true;
    }
}
