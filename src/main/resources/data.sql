INSERT INTO user(id,username,password,active) VALUES (1,'admin','$2a$10$n9qoSXJrVvSZNgGWlbP9qOLN5Hdat6Nuj2Qly4eqkBvIHlHeyz7la',1);
INSERT INTO user(id,username,password,active) VALUES (2,'user','$2a$10$n9qoSXJrVvSZNgGWlbP9qOLN5Hdat6Nuj2Qly4eqkBvIHlHeyz7la',1);

INSERT INTO role (id,role) VALUES(1,'ROLE_ADMIN');
INSERT INTO role (id,role) VALUES(2,'ROLE_USER');

INSERT INTO user_role(user_id, role_id) VALUES (1,1);
INSERT INTO user_role(user_id, role_id) VALUES (2,2);

