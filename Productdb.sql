CREATE
DATABASE bt;

USE
bt;

CREATE TABLE category
(
    `id`   TINYINT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(20) NOT NULL
);


CREATE TABLE product
(
    `id`          INT AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(20) NOT NULL,
    `price`       FLOAT       NOT NULL,
    `quantity`    TINYINT NULL,
    `color`       VARCHAR(20) NOT NULL,
    `category_id` TINYINT,
    CONSTRAINT fk_category FOREIGN KEY (`category_id`)
        REFERENCES category (`id`)
);

INSERT INTO category (`name`)
VALUES ('APPLE'),
       ('SAMSUNG'),
       ('LG');

INSERT INTO product (`name`, `price`, `quantity`, `color`, `category_id`)
VALUES ('IPHONE 12', 30000000, 5, 'BLACK', 1),
       ('Samsung Galaxy Z', 30000000, 5, 'BLACK', 2),
       ('LG G6 ', 1000000, 5, 'BLACK', 3);


DELIMITER
$$
CREATE PROCEDURE edit(
    IN `name` VARCHAR (20), IN `price` INT, IN `quantity` TINYINT,
    IN `color` VARCHAR (20), IN `category_id` INT, IN `id` TINYINT)
BEGIN
UPDATE product p
    INNER JOIN category c
ON p.category_id = c.id
    SET p.name = `name`, p.price = `price`, p.quantity = `quantity`, p.color = `color`, p.category_id = `category_id`
WHERE p.id = `id`;
END; $$
DELIMITER ;


DELIMITER
$$
CREATE PROCEDURE getAll()
BEGIN
SELECT p.id, p.name, p.price, p.quantity, p.color, c.name, p.category_id
FROM category c
         JOIN product p ON p.category_id = c.id;
END; $$
DELIMITER ;


DELIMITER
$$
CREATE PROCEDURE getid(
    IN ids TINYINT)
BEGIN
SELECT *
FROM product
WHERE id = ids;
END; $$
DELIMITER ;


SELECT *
FROM category c
         JOIN
     product p ON p.category_id = c.id;


DELIMITER
$$
CREATE PROCEDURE searchByname(IN idd TINYINT)
BEGIN
SELECT p.id, p.name, p.price, p.quantity, p.color, c.name, p.category_id
FROM category c
         JOIN product p ON p.category_id = c.id
WHERE p.id = idd;
END; $$
DELIMITER ;

SELECT p.id, p.name, p.price, p.quantity, p.color, c.name, p.category_id
FROM category c
         JOIN product p ON p.category_id = c.id
WHERE p.name LIKE "%AB%";


