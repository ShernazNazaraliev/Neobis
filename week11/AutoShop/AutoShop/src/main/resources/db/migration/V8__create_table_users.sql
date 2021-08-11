create table users
(
    user_id bigint not null
        primary key,
    user_password varchar(255) null,
    user_name varchar(255) null
);

create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id)
);

create index FKh8ciramu9cc9q3qcqiv4ue8a6
	on user_roles (role_id);

create table users_seq
(
    next_val bigint null
);

insert into users_seq values(2);