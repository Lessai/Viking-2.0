package com.dp.viking.domain.employee;

import javax.persistence.*;

/*CREATE TABLE viking_oltp.workMode
		(
		workModeID smallint not null Primary KEY
		,workModeCode int UNIQUE
		,workModeName varchar(50) UNIQUE
		);*/
@Entity
@Table(name = "workMode")
public class WorkMode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short workModeID;

    private Integer workModeCode;

    private String workModeName;

    public Short getWorkModeID() {
        return workModeID;
    }

    public void setWorkModeID(Short workModeID) {
        this.workModeID = workModeID;
    }

    public Integer getWorkModeCode() {
        return workModeCode;
    }

    public void setWorkModeCode(Integer workModeCode) {
        this.workModeCode = workModeCode;
    }

    public String getWorkModeName() {
        return workModeName;
    }

    public void setWorkModeName(String workModeName) {
        this.workModeName = workModeName;
    }
}
