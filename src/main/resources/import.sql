--INSERT INTO USERS (id, email, password, first_name, last_name, address, birth_date, is_enabled) VALUES (1, 'm@m', '$2a$12$ilr0IYt.CG2tTRnopavaZeIS/VLOotj7OCzWJPFrpERQZxVEOBdce', 'mari', 'mets', 'marja 3', '2000-01-01', true);
INSERT INTO ROLES (role_id, name) VALUES (1, 'ADMIN');
INSERT INTO ROLES (role_id, name) VALUES (2, 'USER');
--INSERT INTO USERS_ROLES (user_id, role_id, id) VALUES (1, 1, (1, 1));
