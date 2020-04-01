package com.dp.viking.repos.employeeRepo;

import com.dp.viking.domain.employee.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepo extends JpaRepository<Gender, Short> {
    Gender findByGenderName(String genderName);
}