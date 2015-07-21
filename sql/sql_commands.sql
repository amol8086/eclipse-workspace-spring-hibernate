#Create database/schema:

create database localdatabase;

CREATE TABLE Messages(
MessageID int,
MessageText varchar(255),
Gender varchar(255),
Age varchar(255)
); 


ALTER TABLE `localdatabase`.`messages` 
CHANGE COLUMN `MessageID` `MessageID` INT(11) NULL AUTO_INCREMENT COMMENT '' ,
ADD UNIQUE INDEX `MessageID_UNIQUE` (`MessageID` ASC)  COMMENT '',
ADD PRIMARY KEY (`MessageID`)  COMMENT '';
