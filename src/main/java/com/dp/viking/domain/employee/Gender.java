package com.dp.viking.domain.employee;

import javax.persistence.*;

/*CREATE TABLE viking_oltp.gender
		(
		genderID smallint not null Primary KEY
		,genderCode varchar(5) UNIQUE
		,genderName varchar(25) UNIQUE
		);*/
@Entity
@Table(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short genderID;

    private String genderCode;

    private String genderName;

    public Short getGenderID() {
        return genderID;
    }

    public void setGenderID(Short genderID) {
        this.genderID = genderID;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}
