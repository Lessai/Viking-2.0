USE viking_oltp;
SET FOREIGN_KEY_CHECKS=0;
DROP TABLE if exists viking_oltp.categ;
		USE viking_oltp;
		CREATE TABLE viking_oltp.categ
		(
		categID smallint not null Primary KEY
		,categName varchar(50) UNIQUE
		);

		DROP TABLE if exists viking_oltp.title;
		USE viking_oltp;
		CREATE TABLE viking_oltp.title
		(
		titleID smallint not null Primary KEY
		,titleCode smallint UNIQUE
		,titleName varchar(50) UNIQUE
		);

		DROP TABLE if exists viking_oltp.gender;
		USE viking_oltp;
		CREATE TABLE viking_oltp.gender
		(
		genderID smallint not null Primary KEY
		,genderCode varchar(5) UNIQUE
		,genderName varchar(25) UNIQUE
		);

		DROP TABLE if exists viking_oltp.maritalStatus;
		USE viking_oltp;
		CREATE TABLE viking_oltp.maritalStatus
		(
		maritalStatusID smallint not null Primary KEY
		,maritalStatusCode smallint UNIQUE
		,maritalStatusName varchar(25) UNIQUE
		);

		DROP TABLE if exists viking_oltp.workMode;
		USE viking_oltp;
		CREATE TABLE viking_oltp.workMode
		(
		workModeID smallint not null Primary KEY
		,workModeCode int UNIQUE
		,workModeName varchar(50) UNIQUE
		);

SET FOREIGN_KEY_CHECKS=1;