package com.dp.viking.domain.employee;

import javax.persistence.*;

/*CREATE TABLE viking_oltp.title
		(
		titleID smallint not null Primary KEY
		,titleCode smallint UNIQUE
		,titleName varchar(50) UNIQUE
		);*/
@Entity
@Table(name = "title")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short titleID;

    private Short titleCode;

    private String titleName;

    public Short getTitleID() {
        return titleID;
    }

    public void setTitleID(Short titleID) {
        this.titleID = titleID;
    }

    public Short getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(Short titleCode) {
        this.titleCode = titleCode;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
