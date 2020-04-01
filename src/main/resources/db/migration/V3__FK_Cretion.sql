ALTER TABLE viking_oltp.person MODIFY cGenderID smallint;
ALTER TABLE viking_oltp.person MODIFY cMaritalStatusID smallint;
ALTER TABLE viking_oltp.person MODIFY cDepartmentID int;
ALTER TABLE viking_oltp.person MODIFY cCategID smallint;
ALTER TABLE viking_oltp.person MODIFY cTitleID smallint;
ALTER TABLE viking_oltp.person MODIFY cWorkModeID smallint;
ALTER TABLE viking_oltp.department MODIFY cDepartmentManagerID bigint;

ALTER TABLE viking_oltp.person ADD CONSTRAINT FK_Person_Gender FOREIGN KEY (cGenderID) References viking_oltp.gender(genderID);
ALTER TABLE viking_oltp.person ADD CONSTRAINT FK_Person_MaritalStatus FOREIGN KEY (cMaritalStatusID) References viking_oltp.maritalStatus(maritalStatusID);
ALTER TABLE viking_oltp.person ADD CONSTRAINT FK_Person_Department FOREIGN KEY (cDepartmentID) References viking_oltp.department(departmentID);
ALTER TABLE viking_oltp.person ADD CONSTRAINT FK_Person_Categ FOREIGN KEY (cCategID) References viking_oltp.categ(CategID);
ALTER TABLE viking_oltp.person ADD CONSTRAINT FK_Person_Title FOREIGN KEY (cTitleID) References viking_oltp.title(titleID);
ALTER TABLE viking_oltp.person ADD CONSTRAINT FK_Person_WorkMode FOREIGN KEY (cWorkModeID) References viking_oltp.workMode(workModeID);
ALTER TABLE viking_oltp.department ADD CONSTRAINT FK_Department_Manager FOREIGN KEY (cDepartmentManagerID) References viking_oltp.person(personID);
ALTER TABLE viking_oltp.department ADD CONSTRAINT FK_Department_Adderess FOREIGN KEY (cAddressID) References viking_oltp.address(addressID);