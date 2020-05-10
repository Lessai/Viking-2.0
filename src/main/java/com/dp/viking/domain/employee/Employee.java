package com.dp.viking.domain.employee;

/*CREATE TABLE viking_oltp.person
		(
		 personID bigint not null Primary KEY
		,personTabN int UNIQUE
		,personDateIN date
		,personDateOut date
		,personFirstName varchar(50)
		,personLastName varchar(50)
		,cGenderID int
		,cMaritalStatusID int
		,personBirthDate date
		,cDepartmentID int
		,cCategID int
		,cTitleID int
		,cWorkModeID int
		);*/

import com.dp.viking.domain.Department;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "person")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personID;
    @NotNull(message = "Табельный номер не может быть пустым")
    private Integer personTabN;

    private Date personDateIN;
    private Date personDateOut;

    @Length(max = 50, message = "Имя слишком длинное(больше 50 символов)")
    private String personFirstName;
    @Length(max = 50, message = "Фамилия слишком длинная(больше 50 символов)")
    private String personLastName;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cGenderID")
    private Gender gender;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cMaritalStatusID")
    private MaritalStatus maritalStatus;
    private Date personBirthDate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cDepartmentID")
    private Department department;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cCategID")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cTitleID")
    private Title title;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cWorkModeID")
    private WorkMode workMode;

    private String dismissalReason;

    public String getDismissalReason() {
        return dismissalReason;
    }

    public void setDismissalReason(String dismissalReason) {
        this.dismissalReason = dismissalReason;
    }

    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }

    public Integer getPersonTabN() {
        return personTabN;
    }

    public void setPersonTabN(Integer personTabN) {
        this.personTabN = personTabN;
    }

    public Date getPersonDateIN() {
        return personDateIN;
    }

    public void setPersonDateIN(Date personDateIN) {
        this.personDateIN = personDateIN;
    }

    public Date getPersonDateOut() {
        return personDateOut;
    }

    public void setPersonDateOut(Date personDateOut) {
        this.personDateOut = personDateOut;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getPersonBirthDate() {
        return personBirthDate;
    }

    public void setPersonBirthDate(Date personBirthDate) {
        this.personBirthDate = personBirthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public WorkMode getWorkMode() {
        return workMode;
    }

    public void setWorkMode(WorkMode workMode) {
        this.workMode = workMode;
    }
}