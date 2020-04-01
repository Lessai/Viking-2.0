package com.dp.viking.repos.locationRepo;

import com.dp.viking.domain.location.LocalRegion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRegionRepo extends JpaRepository<LocalRegion, Integer> {
    LocalRegion findByLocalRegionCodeOrLocalRegionName(Integer localRegionCode,String localRegionName);
    LocalRegion findByLocalRegionName(String localRegionName);
}
