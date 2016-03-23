CREATE DATABASE jdbcrealm;

CREATE USER 'musa'@'localhost' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON jdbcrealm.* TO 'musa'@'localhost';
FLUSH PRIVILEGES;

USE jdbcrealm;
CREATE TABLE `jdbcrealm`.`users` (
`username` varchar(255) NOT NULL,
`password` varchar(255) DEFAULT NULL,
PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `jdbcrealm`.`groups` (
`username` varchar(255) DEFAULT NULL,
`groupname` varchar(255) DEFAULT NULL)
ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE INDEX groups_users_FK1 ON groups(username ASC);

INSERT INTO users VALUES('bob','81b637d8fcd2c6da6359e6963113a1170de795e4b725b84d1e0b4cfd9ec58ce9');/*pwd: 'bob'*/
INSERT INTO users VALUES('ben','6700869c8ff7480e34a70a708b028700dbaa3a033b5652b903afe89f49a31456');/*pwd: 'ben'*/
INSERT INTO users VALUES('tom','e1608f75c5d7813f3d4031cb30bfb786507d98137538ff8e128a6ff74e84e643');/*pwd: 'tom'*/
INSERT INTO users VALUES('sally','97897a111d485af1048bece173d2980a15870ca079281b79c7ca755356847602');/*pwd: 'sally'*/
INSERT INTO users VALUES('lee','1508b697895abf03d55c3841f59236ab92c9ba6ba89795c8337fcf392fdee8b4');/*pwd: 'lee'*/
INSERT INTO groups VALUES('bob','user');
INSERT INTO groups VALUES('ben','user');
INSERT INTO groups VALUES('tom','user');
INSERT INTO groups VALUES('sally','user');
INSERT INTO groups VALUES('lee','user');