package com.dp.viking.repos.locationRepo;

import com.dp.viking.domain.location.Address;
import com.dp.viking.domain.location.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepo extends JpaRepository<Address, Integer> {
    Address findByStreetAndBuildingAndApartment(Street street, String building, String apartment);

    @Query(value = "SELECT a.addressID, a.cStreetID, a.building, a.apartment FROM Address a JOIN Street s ON a.cStreetID = s.streetID JOIN atdtype satd ON s.cATDTypeID = satd.ATDTypeID JOIN city c ON c.cityID = s.cCityID JOIN atdtype catd ON c.cATDTypeID = catd.ATDTypeID JOIN localregion lr ON lr.localRegionID = c.cLocalRegionID JOIN country cou ON cou.countryID = lr.cCountryID WHERE concat(cou.countryName,', ', catd.atdTypeSName, ' ', c.cityName, ', ', satd.atdTypeSName, ' ', s.streetName, ', ', a.building) = ?1",
            nativeQuery = true)
    Address findAddressByDepartmentAddress(String departmentAddress);
}
