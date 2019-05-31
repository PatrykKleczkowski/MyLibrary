CREATE TABLE `author`(
`id` bigINT NOT NULL AUTO_INCREMENT,
`first_name` VARCHAR(40) NOT NULL,
`last_name` VARCHAR(60) NOT NULL,

PRIMARY KEY(`id`)
);

CREATE TABLE `book`(
`id` bigINT NOT NULL AUTO_INCREMENT,
`title` VARCHAR(120) NOT NULL,
`author_id` bigINT NOT NULL,
`release_date` DATETIME NOT NULL,

PRIMARY KEY(`id`),
FOREIGN KEY (`author_id`) references `author`(`id`) on delete no action on update cascade
);



CREATE TABLE `hire` (
`id` bigINT NOT NULL AUTO_INCREMENT,
`book_id` bigINT NOT NULL,
`user_id` bigINT NOT NULL,
`hire_date_from` DATETIME NOT NULL,
`hire_date_to` DATETIME DEFAULT NULL,

PRIMARY KEY(`id`),
FOREIGN KEY (`book_id`) references `book`(`id`) on delete no action on update cascade,
FOREIGN KEY (`user_id`) references `user`(`id`) on delete no action on update cascade
)
