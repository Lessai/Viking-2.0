package com.dp.viking.repos;

import com.dp.viking.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Integer>{
    Country findByCountryName(String countryName);
}
