package com.dp.viking.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="DepartmentID")
    private Integer departmentId;

    @NotBlank(message = "Please fill the Department Code")
    @Length(max = 20, message = "Department Code too long(more than 20 symbols)")
    @Column(name="DepartmentCode")
    private String departmentCode;

    @Length(max = 150, message = "Department Name too long(more than 150 symbols)")
    @Column(name="DepartmentName")
    private String departmentName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
