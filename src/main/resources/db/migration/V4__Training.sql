CREATE TABLE viking_oltp.training
		(
		trainingID bigint not null Primary KEY
		,trainingName varchar(250)
        ,trainingDesc varchar(500)
        ,trainingCateg varchar(250)
        ,trainingSkill varchar(250)
        ,trainingCondType varchar(50)
        ,trainingType varchar(50)
        ,trainingCapacity int
        ,trainingStartDt date
        ,trainingEndDate date
        ,trainingNrOfSessions int
        ,trainingPrice double
		);