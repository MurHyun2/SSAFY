create database examdb;

use examdb;

CREATE TABLE board(
	no INT AUTO_INCREMENT,
    title VARCHAR(200),
    writer VARCHAR(30),
    content VARCHAR(1000),
    views INT DEFAULT 0,
    reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(no)
);