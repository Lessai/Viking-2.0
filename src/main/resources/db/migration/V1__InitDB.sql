USE viking_oltp;
SET FOREIGN_KEY_CHECKS=0;

drop table if exists hibernate_sequence cascade;
drop table if exists user_role cascade;
drop table if exists usr cascade;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );

create table user_role (
    user_id bigint not null,
    roles varchar(255)
) engine=InnoDB;

create table usr (
    id bigint not null,
    activationCode varchar(255),
    active bit not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
) engine=InnoDB;

alter table user_role add constraint user_role_user_fk foreign key (user_id) references usr (id);

DROP TABLE if exists viking_oltp.region;
USE viking_oltp;
CREATE TABLE viking_oltp.region
		(
		regionID int not null Primary KEY
		,regionName varchar(50) UNIQUE
		);

DROP TABLE if exists viking_oltp.atdType;
CREATE TABLE viking_oltp.atdType
		(
		atdTypeID int not null Primary KEY
		,atdTypeName varchar(50) UNIQUE NOT NULL
		,atdTypeSName varchar(10)
		);

DROP TABLE if exists viking_oltp.country;
USE viking_oltp;
CREATE TABLE viking_oltp.country
		(
		countryID int not null Primary KEY
		,countryCode varchar(5) UNIQUE
		,countryName varchar(50) UNIQUE
		,cRegionID int
		);

DROP TABLE if exists viking_oltp.localRegion;
USE viking_oltp;
		CREATE TABLE viking_oltp.localRegion
		(
		localRegionID int not null Primary KEY
		,localRegionCode int UNIQUE
		,localRegionName varchar(50) UNIQUE
		,cCountryID int
		,cATDTypeID int
		);

DROP TABLE if exists viking_oltp.city;
USE viking_oltp;
CREATE TABLE viking_oltp.city
		(
		cityID int not null Primary KEY
		,cityCode smallint
		,cityName varchar(50) UNIQUE
		,cLocalRegionID int
		,cATDTypeID int
		);

DROP TABLE if exists viking_oltp.street;
USE viking_oltp;
		CREATE TABLE viking_oltp.street
		(
		streetID int not null Primary KEY
		,ctreetName varchar(150)
		,cCityID int
		,cATDTypeID int
		);

DROP TABLE if exists viking_oltp.address;
USE viking_oltp;
CREATE TABLE viking_oltp.address
		(
		addressID int not null Primary KEY
		,building varchar(10)
		,bppartments varchar(10)
		,cStreetID int
		);

ALTER TABLE viking_oltp.country ADD CONSTRAINT FK_Country_Region FOREIGN KEY (cRegionID) References viking_oltp.region(regionID);
ALTER TABLE viking_oltp.localRegion ADD CONSTRAINT FK_LocalRegion_Country FOREIGN KEY (cCountryID) References viking_oltp.country(countryID);
ALTER TABLE viking_oltp.city ADD CONSTRAINT FK_City_LocalRegion FOREIGN KEY (cLocalRegionID) References viking_oltp.LocalRegion(localRegionID);
ALTER TABLE viking_oltp.city ADD CONSTRAINT FK_City_ATDType FOREIGN KEY (cATDTypeID) References viking_oltp.atdType(atdTypeID);
ALTER TABLE viking_oltp.street ADD CONSTRAINT FK_Street_City FOREIGN KEY (cCityID) References viking_oltp.city(cityID);
ALTER TABLE viking_oltp.street ADD CONSTRAINT FK_Street_ATDType FOREIGN KEY (cATDTypeID) References viking_oltp.atdType(atdTypeID);
ALTER TABLE viking_oltp.address ADD CONSTRAINT FK_Address_Street FOREIGN KEY (cStreetID) References viking_oltp.street(streetID);

DROP TABLE if exists viking_oltp.department;
USE viking_oltp;
CREATE TABLE viking_oltp.department
		(
		departmentID int not null Primary KEY
		,departmentCode varchar(20)
		,departmentName varchar(150)
		,cDepartmentManagerID int
		,cAddressID int
		);

DROP TABLE if exists viking_oltp.person;
USE viking_oltp;
		CREATE TABLE viking_oltp.person
		(
		 personID bigint not null Primary KEY
		,personTabN int UNIQUE
		,personDateIN date
		,personDateOut date
		,personFirstName varchar(50)
		,personLastName varchar(50)
		,cGenderID int
		,cMaritalStatusID int
		,personBirthDate date
		,cDepartmentID int
		,cCategID int
		,cTitleID int
		,cWorkModeID int
		);

SET FOREIGN_KEY_CHECKS=1;
