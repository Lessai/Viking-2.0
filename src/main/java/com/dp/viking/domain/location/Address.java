package com.dp.viking.domain.location;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

/*CREATE TABLE viking_oltp.address
		(
		addressID int not null Primary KEY
		,building varchar(10)
		,apartment varchar(10)
		,cStreetID int
		);*/

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer addressID;

    @Length(max = 10, message = "Номер здания слишком длинный(больше 10 символов)")
    private String building;

    @Length(max = 10, message = "Номер квартиры слишком длинный(больше 10 символов)")
    private String apartment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cStreetID")
    private Street street;

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
