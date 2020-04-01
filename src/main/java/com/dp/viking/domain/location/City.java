package com.dp.viking.domain.location;

/*CREATE TABLE viking_oltp.city
		(
		cityID int not null Primary KEY
		,cityCode smallint
		,cityName varchar(50) UNIQUE
		,cLocalRegionID int
		,cATDTypeID int
		);
*/

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer cityID;

    private Short cityCode;

    @Length(max = 50, message = "City Name is too long(more than 50 symbols)")
    private String cityName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cLocalRegionID")
    private LocalRegion localRegion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cATDTypeID")
    private ATDType atdType;

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public Short getCityCode() {
        return cityCode;
    }

    public void setCityCode(Short cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalRegion getLocalRegion() {
        return localRegion;
    }

    public void setLocalRegion(LocalRegion localRegion) {
        this.localRegion = localRegion;
    }

    public ATDType getAtdType() {
        return atdType;
    }

    public void setAtdType(ATDType atdType) {
        this.atdType = atdType;
    }
}
