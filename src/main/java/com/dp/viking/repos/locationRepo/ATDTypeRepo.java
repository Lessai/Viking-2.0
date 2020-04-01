package com.dp.viking.repos.locationRepo;

import com.dp.viking.domain.location.ATDType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ATDTypeRepo extends JpaRepository<ATDType, Integer> {
    ATDType findByAtdTypeNameAndAtdTypeSName(String atdTypeName, String atdTypeSName);
    ATDType findByAtdTypeName(String atdTypeName);
}

