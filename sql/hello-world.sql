DROP DATABASE IF EXISTS `hello-world`;
CREATE DATABASE `hello-world`;

USE `hello-world`;

CREATE TABLE `message` (
    `ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `TEXT` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`ID`)
);

SELECT *
FROM message