package com.dp.viking.repos.employeeRepo;

import com.dp.viking.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByPersonTabN(Integer personTabN);

    Employee findByPersonFirstNameAndPersonLastName(String firstName, String LastName);

    @Query(value = "Select max(p.personTabN)+1 from person p", nativeQuery = true)
    Integer findNextTabN();

    @Query("select e " +
            "from Employee e left join e.department d " +
            "left join e.category c " +
            "where  (d.departmentName = :departmentFilter and :departmentFilter <> 'Все') or " +
            "(c.categName = :categoryFilter and :categoryFilter <> 'Все') or " +
            "(e.personFirstName = :filterFirstName and :filterFirstName <> 'Имя') or " +
            "(e.personLastName = :filterLastName and :filterLastName <> 'Фамилия') " +
            "group by e " )
    List<Employee> findEmployeesByFilter(@Param("departmentFilter") String departmentFilter,
                                         @Param("categoryFilter") String categoryFilter,
                                         @Param("filterFirstName") String filterFirstName,
                                         @Param("filterLastName") String filterLastName);

}