package com.dp.viking.domain;

import javax.persistence.*;


/*CREATE TABLE viking_oltp.country
        (
        countryID int not null Primary KEY
        ,countryCode varchar(5) UNIQUE
        ,countryName varchar(50) UNIQUE
        ,cRegionID int
        );*/

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer countryID;

    private String countryCode;

    private String countryName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cRegionID")
    private Region region;

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
