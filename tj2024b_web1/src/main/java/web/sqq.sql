
drop database if exists jspweb;
create database jspweb;
-- create database jspweb;
use jspweb; -- 없으면 새로 생성하기 
-- 회원테이블
create table member(
	mno		int auto_increment  , -- 식별번호 
    mid		varchar(30) not null  unique, -- 회원 아이디 [ 공백불가 , 중복불가 ] 	
    mpwd	varchar(20) not null , -- 회원 비밀번호 [ 공백불가 ]
    mimg	varchar(255) , -- 웹서버에 저장된 사진 경로  [ 공백가능 ]
	memail	varchar(50) not null unique, -- 회원 이메일 [ 공백불가 , 중복불가 ] 
    mdate datetime default now(),
	constraint primary key( mno )
);
select * from member;