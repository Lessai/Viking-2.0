package com.dp.viking.repos.employeeRepo;

import com.dp.viking.domain.employee.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepo extends JpaRepository<Title, Short> {
    Title findByTitleName(String titleName);
}