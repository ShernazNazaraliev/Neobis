create table roles
(
    role_id bigint not null
        constraint roles_pkey
            primary key,
    role    varchar(255)
);

create sequence roles_seq START 1;
