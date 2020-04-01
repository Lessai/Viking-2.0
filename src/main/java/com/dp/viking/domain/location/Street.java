package com.dp.viking.domain.location;

import com.dp.viking.domain.location.ATDType;
import com.dp.viking.domain.location.City;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/*
CREATE TABLE viking_oltp.street
		(
		streetID int not null Primary KEY
		,streetName varchar(150)
		,cCityID int
		,cATDTypeID int
		);*/
@Entity
@Table(name = "street")
public class Street {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer streetID;

    @Length(max = 50, message = "Street Name is too long(more than 150 symbols)")
    private String streetName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cCityID")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cATDTypeID")
    private ATDType atdType;

    public Integer getStreetID() {
        return streetID;
    }

    public void setStreetID(Integer streetID) {
        this.streetID = streetID;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public ATDType getAtdType() {
        return atdType;
    }

    public void setAtdType(ATDType atdType) {
        this.atdType = atdType;
    }
}
