package com.dp.viking.repos.employeeRepo;

import com.dp.viking.domain.employee.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Short> {
    Category findByCategName(String categName);
}
