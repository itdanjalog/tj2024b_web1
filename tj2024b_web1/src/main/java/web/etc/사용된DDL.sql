# 프로젝트 : boardservice10 DML 과 샘플 INSERT
# 1. DB 구성한다.
drop database if exists jspweb;		# 1. 만일 'boardservice10' DB명이 존재하면 삭제
create database jspweb;				# 2. 'boardservice10' DB 생성 
use jspweb;							# 3. 'boardservice10' 사용
# 2. 테이블 생성  , PK 테이블 먼저 생성 한다. 적절하게 타입 과 제약조건을 고려한다.

# [1] 회원테이블 생성 
create table member(
	mno int unsigned auto_increment , 
    mid varchar(30) not null unique ,
    mpwd varchar(30) not null ,
    mname varchar(20) not null ,
    mphone varchar(13) not null unique , 
    mdate datetime default now() , 
    constraint primary key( mno )
); # table end 