package com.dp.viking.domain.employee;

import javax.persistence.*;

/*CREATE TABLE viking_oltp.maritalStatus
		(
		maritalStatusID smallint not null Primary KEY
		,maritalStatusCode smallint UNIQUE
		,maritalStatusName varchar(25) UNIQUE
		);*/
@Entity
@Table(name = "maritalStatus")
public class MaritalStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short maritalStatusID;

    private Short maritalStatusCode;

    private String maritalStatusName;

    public Short getMaritalStatusID() {
        return maritalStatusID;
    }

    public void setMaritalStatusID(Short maritalStatusID) {
        this.maritalStatusID = maritalStatusID;
    }

    public Short getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(Short maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getMaritalStatusName() {
        return maritalStatusName;
    }

    public void setMaritalStatusName(String maritalStatusName) {
        this.maritalStatusName = maritalStatusName;
    }
}
