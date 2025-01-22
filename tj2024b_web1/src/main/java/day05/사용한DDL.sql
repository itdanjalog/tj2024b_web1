# DDL 
# 데이터베이스 준비 : db 서버의 여러개 테이블들을 저장할 수 있는 공간 
drop database if exists mydb0122;		#[1] 만약에 동일한 DB명이 존재하면 데이터베이스 삭제 
create database mydb0122;				#[2] 지정한 DB명으로 데이터베이스 생성 
use mydb0122;							#[3] 지정한 DB를 활성화/사용
# 테이블 준비 : 행/열 로 이루어진 표/테이블 
create table board( # 테이블명은 임의로 하되 저장할 데이터와 의미있는 이름으로 정하기.
	bno int auto_increment , 		# 게시물번호 
    btitle varchar(100),			# 게시물제목 
    bcontent longtext,				# 게시물내용 
    bwriter varchar(10),			# 게시물작성자
    bpwd varchar(10),				# 게시물비밀번호 
    bdate datetime default now(),	# 게시물작성일 
    bview int default 0,			# 게시물조회수 
    constraint primary key( bno )	# 게시물번호를 pk로 설정 
);