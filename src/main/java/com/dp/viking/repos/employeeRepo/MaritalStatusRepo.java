package com.dp.viking.repos.employeeRepo;

import com.dp.viking.domain.employee.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusRepo extends JpaRepository<MaritalStatus, Short> {
    MaritalStatus findByMaritalStatusName(String maritalStatusName);
}