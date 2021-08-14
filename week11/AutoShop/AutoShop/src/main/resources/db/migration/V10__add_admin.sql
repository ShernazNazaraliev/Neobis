INSERT INTO users(user_id,user_name,user_password)
VALUES (1, 'admin','$2a$10$LlgRxeYJTuM3cIG6gIqfH.C7XVirmMttafYoLMBO9uCGq7OXg59xC');

INSERT INTO user_roles(user_id, role_id)
VALUES (1, 2);