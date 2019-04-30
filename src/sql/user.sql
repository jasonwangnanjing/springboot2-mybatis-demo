CREATE DATABASE mytest;

CREATE TABLE t_user(
  userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userName VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


ALTER TABLE `ssmdemo`.`tb_user`
CHANGE COLUMN `password` `password` VARCHAR(60) NULL DEFAULT NULL ;


CREATE TABLE t_user(
                     userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     userName VARCHAR(255) NOT NULL ,
                     password VARCHAR(255) NOT NULL ,
                     phone VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

use ssmdemo;

CREATE TABLE ssmdemo.tb_permission(
                                    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                    name VARCHAR(255) NOT NULL ,
                                    roleCode INT(6) NOT NULL,
                                    sort INT(2) NOT NULL,
                                    authType INT(4) NOT NULL,
                                    url VARCHAR(60) NOT NULL

) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

use ssmdemo;

CREATE TABLE ssmdemo.tb_role(
                                    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                    name VARCHAR(255) NOT NULL ,
                                    roleCode INT(6) NOT NULL

) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

CREATE TABLE ssmdemo.tb_user_role(
                                    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                    user_name VARCHAR(255) NOT NULL ,
                                    roleCode INT(6) NOT NULL

) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;