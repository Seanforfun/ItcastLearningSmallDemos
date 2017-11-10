CREATE DATABASE day24;

USE day24;

CREATE TABLE users(
	id  INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(40),
	PASSWORD VARCHAR(40)
);

DESC users;

INSERT INTO users VALUES(NULL, "aaa", "111");
INSERT INTO users VALUES(NULL, "bbb", "222");
INSERT INTO users VALUES(NULL, "ccc", "333");

SELECT * FROM users;

CREATE TABLE PRIVILEGES(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(40)
);

INSERT INTO PRIVILEGES VALUES(NULL, "add book");
INSERT INTO PRIVILEGES VALUES(NULL, "update book");
INSERT INTO PRIVILEGES VALUES(NULL, "search book");
INSERT INTO PRIVILEGES VALUES(NULL, "delete book");

SELECT * FROM PRIVILEGES;

CREATE TABLE userprivilege(
	user_id INT,
	privilege_id INT,
	FOREIGN KEY(user_id) REFERENCES users(id),
	FOREIGN KEY(privilege_id) REFERENCES PRIVILEGES(id),
	PRIMARY KEY(user_id, privilege_id)
);

INSERT INTO userprivilege VALUES(1,1);
INSERT INTO userprivilege VALUES(1,2);
INSERT INTO userprivilege VALUES(2,1);
INSERT INTO userprivilege VALUES(3,4);
INSERT INTO userprivilege VALUES(2,3);
INSERT INTO userprivilege VALUES(1,3);
INSERT INTO userprivilege VALUES(1,4);

SELECT * FROM users;

SELECT users.id, PRIVILEGES.name FROM users, PRIVILEGES, userprivilege WHERE users.id=userprivilege.user_id AND PRIVILEGES.id = userprivilege.privilege_id AND users.id = ?;