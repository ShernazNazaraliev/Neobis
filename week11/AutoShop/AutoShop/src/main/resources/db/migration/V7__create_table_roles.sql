create table roles
(
    role_id bigint not null
        primary key,
    role varchar(255) null
);

create table roles_seq
(
    next_val bigint
);

insert into roles_seq values(3);
