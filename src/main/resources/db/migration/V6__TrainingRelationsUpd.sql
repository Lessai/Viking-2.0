drop table viking_oltp.training_register;
drop table viking_oltp.training_likes;
create table viking_oltp.training_register(
    trainingID bigint not null references training,
    personID bigint not null references usr,
    primary key (trainingID, personID)
);

create table viking_oltp.training_likes(
    trainingID bigint not null references training,
    personID bigint not null references usr,
    primary key (trainingID, personID)
);