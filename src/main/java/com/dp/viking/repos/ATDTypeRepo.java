package com.dp.viking.repos;

import com.dp.viking.domain.ATDType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ATDTypeRepo extends JpaRepository<ATDType, Integer> {
    ATDType findByAtdTypeNameAndAtdTypeSName(String AtdTypeName, String AtdTypeSName);
}

