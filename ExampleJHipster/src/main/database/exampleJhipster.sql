DROP DATABASE IF EXISTS qLStudent;
CREATE DATABASE qLStudent;

USE qLStudent;


DROP TABLE IF EXISTS Student;
CREATE TABLE Student(

	maSv 					INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
	`name`				    VARCHAR(50) NOT NULL,
	score 				    FLOAT NOT NULL DEFAULT 0,
	class					VARCHAR(50)
);

insert into Student (name, class, score) values ('Hatti Fursey', 'KHMT4', 10);
insert into Student (name, class, score) values ('Bertine Cloute', 'KHMT4', 8);
insert into Student (name, class, score) values ('Allister Londsdale', 'KHMT1', 7);
insert into Student (name, class, score) values ('Karlik Seacroft', 'KHMT4', 9);
insert into Student (name, class, score) values ('Andris Crallan', 'KHMT1', 8);
insert into Student (name, class, score) values ('Anya Crosfield', 'KHMT2', 6);
insert into Student (name, class, score) values ('Janella Steane', 'KHMT3', 9);
insert into Student (name, class, score) values ('Chris Denver', 'KHMT1', 9);
insert into Student (name, class, score) values ('Wilhelmine Douberday', 'KHMT2', 10);
insert into Student (name, class, score) values ('Elsa MacFarlane', 'KHMT4', 8);
insert into Student (name, class, score) values ('Townie Sherar', 'KHMT1', 5);
insert into Student (name, class, score) values ('Abner Cicconetti', 'KHMT3', 7);
insert into Student (name, class, score) values ('Quincey Zaple', 'KHMT1', 7);
insert into Student (name, class, score) values ('Sawyer Swansbury', 'KHMT1', 5);
insert into Student (name, class, score) values ('Halimeda Anstice', 'KHMT3', 9);
insert into Student (name, class, score) values ('Tresa Cushion', 'KHMT1', 7);
insert into Student (name, class, score) values ('Ashleigh Barringer', 'KHMT3', 10);
insert into Student (name, class, score) values ('Caryn Andrichak', 'KHMT1', 8);
insert into Student (name, class, score) values ('Maryl Goss', 'KHMT3', 6);
insert into Student (name, class, score) values ('Shane Stripp', 'KHMT1', 8);
insert into Student (name, class, score) values ('Hallie Baterip', 'KHMT1', 7);
insert into Student (name, class, score) values ('Iormina Weedenburg', 'KHMT4', 6);
insert into Student (name, class, score) values ('Wallis Crumpton', 'KHMT2', 7);
insert into Student (name, class, score) values ('Madelene Rogliero', 'KHMT3', 10);
insert into Student (name, class, score) values ('Dino Aronov', 'KHMT1', 10);
insert into Student (name, class, score) values ('Kip Profit', 'KHMT1', 10);
insert into Student (name, class, score) values ('Creigh McEvilly', 'KHMT4', 9);
insert into Student (name, class, score) values ('Fayette McFarland', 'KHMT2', 10);
insert into Student (name, class, score) values ('Vivianne Pender', 'KHMT3', 7);
insert into Student (name, class, score) values ('Erastus Rickaert', 'KHMT3', 5);
insert into Student (name, class, score) values ('Kelila Bartles', 'KHMT2', 7);
insert into Student (name, class, score) values ('Daphna Kelling', 'KHMT4', 9);
insert into Student (name, class, score) values ('Danna Marchent', 'KHMT3', 10);
insert into Student (name, class, score) values ('Linc Arnau', 'KHMT1', 6);
insert into Student (name, class, score) values ('Abagael Treanor', 'KHMT4', 5);
insert into Student (name, class, score) values ('Rafferty Veeler', 'KHMT2', 8);	
insert into Student (name, class, score) values ('Jens O''Logan', 'KHMT4', 8);
insert into Student (name, class, score) values ('Tim Brundell', 'KHMT1', 7);
insert into Student (name, class, score) values ('Janenna Pawels', 'KHMT3', 5);
insert into Student (name, class, score) values ('Beck Wingham', 'KHMT3', 10);
