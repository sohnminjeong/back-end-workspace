CREATE TABLE person(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    address VARCHAR(30)
);

INSERT INTO person(id, name, address) VALUES(?, ?, ?);
UPDATE person set address = "제주도" WHERE id = 111;
DELETE FROM person WHERE id = 111;

CREATE TABLE member(
	id VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    name VARCHAR(20)
);

SELECT name FROM member WHERE id = "son" AND password = "choi";