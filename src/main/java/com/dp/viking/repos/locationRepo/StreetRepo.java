package com.dp.viking.repos.locationRepo;

import com.dp.viking.domain.location.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepo extends JpaRepository<Street, Integer>{
    Street findByStreetName(String streetName);
}