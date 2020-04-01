create table training_register(
    trainingID bigint not null references training,
    personID bigint not null references person,
    primary key (trainingID, personID)
);

create table training_likes(
    trainingID bigint not null references training,
    personID bigint not null references person,
    primary key (trainingID, personID)
);

