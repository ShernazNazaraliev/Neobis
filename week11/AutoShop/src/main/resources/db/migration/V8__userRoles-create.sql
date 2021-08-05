create table if not exists user_roles
(
    user_id bigint not null,
    role_id bigint not null
    );

create table if not exists user_seq
(
    next_val bigint null
);

