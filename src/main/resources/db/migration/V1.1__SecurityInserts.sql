INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ROLE_ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'ROLE_USER');

INSERT INTO user(id, username, password, id_role) VALUES
(1, 'Admin', '$2a$04$iRsccpxqihb7QvTewwyncOVpMTF/xLX4YekCDIgUi4b.BBzM4uRdi',1);

INSERT INTO user(id, username, password,id_role) VALUES
(2, 'User', '$2a$10$HWgaoxfn.qba97nv3mMnZ.2X7fHyBnwS9UOZjis1XkzP4k8RUwZ.y',2);