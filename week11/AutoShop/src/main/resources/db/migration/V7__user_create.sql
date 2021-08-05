create table if not exists user
(
    user_id bigint not null
    primary key,
    password varchar(255) null,
    user_name varchar(255) null
    );

