package com.dp.viking.domain.employee;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/*CREATE TABLE viking_oltp.categ
		(
		categID smallint not null Primary KEY
		,categName varchar(50) UNIQUE
		);*/
@Entity
@Table(name = "categ")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short categID;

    private String categName;

    public Short getCategID() {
        return categID;
    }

    public void setCategID(Short categID) {
        this.categID = categID;
    }

    public String getCategName() {
        return categName;
    }

    public void setCategName(String categName) {
        this.categName = categName;
    }
}