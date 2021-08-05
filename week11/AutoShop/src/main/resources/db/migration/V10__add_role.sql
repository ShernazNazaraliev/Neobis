INSERT INTO roles(role_id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO users(user_id,user_name,password)
VALUES (1,'admin','$2a$10$hrXTB/X9SqbaHNawyV5zw.r2OOvjQbbD3MjyBLRnONVgN5HjKAyyS');

INSERT INTO user_roles(user_id, role_id)
VALUES (1, 2);