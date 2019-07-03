CREATE TABLE role (
id UUID PRIMARY KEY,
description varchar(255),
name varchar(255)

);

CREATE TABLE user_entity (
id UUID,
username varchar(255),
password varchar(255),
banned boolean NOT NULL  default false,
active boolean NOT NULL  default true,
id_role UUID,
last_login TIMESTAMP default null,
registered TIMESTAMP default null,

PRIMARY KEY (id),
foreign key(id_role) references role (id) on delete cascade);