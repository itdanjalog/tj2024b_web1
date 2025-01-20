drop database if exists mydb0120;
create database mydb0116;
use mydb0116;
create table visit(
	num int auto_increment ,
    content longtext , 
    age int ,
    constraint primary key(num)
);