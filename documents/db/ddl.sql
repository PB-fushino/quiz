create database training;

use training;

create table user (
	id integer primary key AUTO_INCREMENT, 
	name varchar(255) not null,
	age integer not null
);

insert into user (name, age) values ("sakata", 42), ("sakaue", 28),("sakiyama", 19);