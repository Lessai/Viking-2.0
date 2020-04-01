package com.dp.viking.repos.employeeRepo;

import com.dp.viking.domain.employee.WorkMode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkModeRepo extends JpaRepository<WorkMode, Short> {
    WorkMode findByWorkModeName(String workModeName);
}