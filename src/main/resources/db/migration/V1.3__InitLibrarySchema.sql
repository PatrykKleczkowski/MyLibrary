CREATE TABLE author(
id bigINT NOT NULL,
first_name VARCHAR(40) NOT NULL,
last_name VARCHAR(60) NOT NULL,

PRIMARY KEY(id)
);

CREATE TABLE book(
id bigINT NOT NULL,
title VARCHAR(120) NOT NULL,
author_id bigINT NOT NULL,
release_date DATE NOT NULL,

PRIMARY KEY(id),
FOREIGN KEY (author_id) references author(id) on delete no action on update cascade
);



CREATE TABLE hire (
id bigINT NOT NULL,
book_id bigINT NOT NULL,
user_id bigINT NOT NULL,
hire_date_from DATE NOT NULL,
hire_date_to DATE DEFAULT NULL,

PRIMARY KEY(id),
FOREIGN KEY (book_id) references book(id) on delete no action on update cascade,
FOREIGN KEY (user_id) references user_entity(id) on delete no action on update cascade
)
