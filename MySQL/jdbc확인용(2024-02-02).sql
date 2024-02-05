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

SELECT * FROM member;

SELECT name FROM member WHERE id = "son" AND password = "choi";

 UPDATE member SET password = "바뀔비밀번호" WHERE id = "손";
 
CREATE TABLE bank(
	name VARCHAR(20),
    bankname VARCHAR(20),
    balance INT
);

SELECT * FROM bank;

INSERT INTO bank VALUES('정대윤', '국민은행', 1000000);
INSERT INTO bank VALUES('신대규', '신한은행', 0);

UPDATE bank SET balance = 50000 WHERE name = '정대윤'; 