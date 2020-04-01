package com.dp.viking.domain.location;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "atdType")
public class ATDType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer atdTypeID;
    private String atdTypeName;
    private String atdTypeSName;

    public Integer getAtdTypeID() {
        return atdTypeID;
    }

    public void setAtdTypeID(Integer atdTypeID) {
        this.atdTypeID = atdTypeID;
    }

    public String getAtdTypeName() {
        return atdTypeName;
    }

    public void setAtdTypeName(String atdTypeName) {
        this.atdTypeName = atdTypeName;
    }

    public String getAtdTypeSName() {
        return atdTypeSName;
    }

    public void setAtdTypeSName(String atdTypeSName) {
        this.atdTypeSName = atdTypeSName;
    }
}
