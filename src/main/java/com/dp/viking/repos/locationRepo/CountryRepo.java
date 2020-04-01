package com.dp.viking.repos.locationRepo;

import com.dp.viking.domain.location.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Integer>{
    Country findByCountryName(String countryName);
}
