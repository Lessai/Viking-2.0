package com.dp.viking.service;

import com.dp.viking.domain.Department;
import com.dp.viking.repos.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private DepartmentRepo departmentRepo;

    public List<Department> findAllDepartments() {
        return departmentRepo.findAll();
    }
}
