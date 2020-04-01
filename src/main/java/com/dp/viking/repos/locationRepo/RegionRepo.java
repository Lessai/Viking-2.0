package com.dp.viking.repos.locationRepo;

import com.dp.viking.domain.location.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<Region, Integer> {
    Region findByRegionName(String regionName);
}
