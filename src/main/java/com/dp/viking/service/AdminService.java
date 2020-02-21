package com.dp.viking.service;

import com.dp.viking.domain.ATDType;
import com.dp.viking.domain.Country;
import com.dp.viking.domain.Department;
import com.dp.viking.domain.Region;
import com.dp.viking.repos.ATDTypeRepo;
import com.dp.viking.repos.CountryRepo;
import com.dp.viking.repos.DepartmentRepo;
import com.dp.viking.repos.RegionRepo;
import freemarker.core.UnregisteredOutputFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private RegionRepo regionRepo;

    @Autowired
    private ATDTypeRepo atdTypeRepo;

    @Autowired
    private CountryRepo countryRepo;

    /************************   DEPARTMENT   ***************************/
    public List<Department> findAllDepartments() {
        return departmentRepo.findAll();
    }

    public boolean addDepartment(String departmentCode, String departmentName) {
        Department departmentFromDb = departmentRepo.findByDepartmentName(departmentName);

        if (departmentFromDb != null) {
            return false;
        }

        Department department = new Department();
        department.setDepartmentName(departmentName);
        department.setDepartmentCode(departmentCode);

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
}
