INSERT INTO author (id, first_name, last_name) VALUES (1, 'George R.R', 'Martin');
INSERT INTO author (id, first_name, last_name) VALUES (2, 'John R.R', 'Tolkien');
INSERT INTO author (id, first_name, last_name) VALUES (3, 'Joanne K', 'Rowling');
INSERT INTO author (id, first_name, last_name) VALUES (4, 'C.S', 'Lewis');

INSERT INTO book (id, title, author_id, release_date)
VALUES (1, 'A Clash of Kings', 1, '1999-05-28 18:06:32');

INSERT INTO book (id, title, author_id, release_date)
VALUES (2, 'A Dance with Dragons', 1, '2011-05-28 18:06:32');

INSERT INTO book (id, title, author_id, release_date)
VALUES (3, 'The Fellowship of the Ring', 2, '1954-05-28 18:06:32');

INSERT INTO book (id, title, author_id, release_date)
VALUES (4, 'Harry Potter and the Philosopher’s Stone', 3, '2000-05-28 18:06:32');

INSERT INTO book (id, title, author_id, release_date)
VALUES (5, 'The Lion, the Witch and the Wardrobe', 4, '1950-05-28 18:06:32');