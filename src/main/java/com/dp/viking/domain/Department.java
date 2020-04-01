package com.dp.viking.domain;

import com.dp.viking.domain.employee.Employee;
import com.dp.viking.domain.location.Address;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
/*CREATE TABLE viking_oltp.department
		(
		departmentID int not null Primary KEY
		,departmentCode varchar(20)
		,departmentName varchar(150)
		,cDepartmentManagerID int
		,cAddressID int
		);*/
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="departmentID")
    private Integer departmentId;

    @NotBlank(message = "Please fill the Department Code")
    @Length(max = 20, message = "Department Code too long(more than 20 symbols)")
    @Column(name="departmentCode")
    private String departmentCode;

    @Length(max = 150, message = "Department Name too long(more than 150 symbols)")
    @Column(name="departmentName")
    private String departmentName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cAddressID")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cDepartmentManagerID")
    private Employee departmentManager;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }
}
