CREATE TABLE role (
id bigint NOT NULL,
description varchar(255),
name varchar(255),
PRIMARY KEY (id));

CREATE TABLE user_entity (
id bigint NOT NULL,
username varchar(255),
password varchar(255),
banned boolean NOT NULL  default false,
active boolean NOT NULL  default true,
id_role bigint,
last_login DATE default null,
registered DATE default null,

PRIMARY KEY (id),
foreign key(id_role) references role (id) on delete cascade);