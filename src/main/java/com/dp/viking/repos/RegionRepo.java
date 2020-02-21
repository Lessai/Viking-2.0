package com.dp.viking.repos;

import com.dp.viking.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepo extends JpaRepository<Region, Integer> {
    Region findByRegionName(String regionName);
}
