package com.dp.viking.domain.location;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;

/*CREATE TABLE viking_oltp.localRegion
                (
                localRegionID int not null Primary KEY
                ,localRegionCode int UNIQUE
                ,localRegionName varchar(50) UNIQUE
                ,cCountryID int
                ,cATDTypeID int
                );*/
@Entity
@Table(name = "localRegion")
public class LocalRegion {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer localRegionID;

    private Integer localRegionCode;

    @Length(max = 50, message = "Local Region Name too long(more than 50 symbols)")
    private String localRegionName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cCountryID")
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cATDTypeID")
    private ATDType atdType;

    public Integer getLocalRegionID() {
        return localRegionID;
    }

    public void setLocalRegionID(Integer localRegionID) {
        this.localRegionID = localRegionID;
    }

    public Integer getLocalRegionCode() {
        return localRegionCode;
    }

    public void setLocalRegionCode(Integer localRegionCode) {
        this.localRegionCode = localRegionCode;
    }

    public String getLocalRegionName() {
        return localRegionName;
    }

    public void setLocalRegionName(String localRegionName) {
        this.localRegionName = localRegionName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public ATDType getAtdType() {
        return atdType;
    }

    public void setAtdType(ATDType atdType) {
        this.atdType = atdType;
    }
}
