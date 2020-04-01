package com.dp.viking.repos.employeeRepo;

import com.dp.viking.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByPersonTabN(Integer personTabN);

    Employee findByPersonFirstNameAndPersonLastName(String firstName, String LastName);

    @Query(value = "Select max(p.personTabN)+1 from person p", nativeQuery = true)
    Integer findNextTabN();
}