CREATE TABLE author(
id UUID PRIMARY KEY,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(60) NOT NULL
);

CREATE TABLE book(
id UUID PRIMARY KEY,
title VARCHAR(120) NOT NULL,
author_id UUID NOT NULL,
release_date TIMESTAMP NOT NULL,

FOREIGN KEY (author_id) references author(id) on delete no action on update cascade
);



CREATE TABLE hire (
id UUID PRIMARY KEY,
book_id UUID NOT NULL,
user_id UUID NOT NULL,
hire_date_from TIMESTAMP NOT NULL,
hire_date_to TIMESTAMP DEFAULT NULL,

FOREIGN KEY (book_id) references book(id) on delete no action on update cascade,
FOREIGN KEY (user_id) references user_entity(id) on delete no action on update cascade
);
