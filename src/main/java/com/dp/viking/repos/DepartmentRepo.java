package com.dp.viking.repos;

import com.dp.viking.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepo  extends JpaRepository<Department, Integer> {
    Department findByDepartmentName(String departmentName);

}
