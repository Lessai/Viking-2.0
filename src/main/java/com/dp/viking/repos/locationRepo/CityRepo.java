package com.dp.viking.repos.locationRepo;

import com.dp.viking.domain.location.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Integer> {
    City findByCityName(String cityName);
}
