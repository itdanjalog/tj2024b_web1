use mydb0122;							#[3] 지정한 DB를 활성화/사용
# DML : insert , select , update , delete 
#(1) 게시물 등록 
insert into board( btitle , bcontent , bwriter, bpwd ) values( '테스트제목1' , '테스트내용1' , '테스트작성자1' , '테스트비밀번호1' );
# DAO : String sql = "insert into board( btitle , bcontent , bwriter, bpwd ) values( ? , ? , ? , ? )";
#(2) 게시물 전체 조회
select * from board;
# DAO :String sql = "select * from board";
#(3) 게시물 개별 조회
select * from board where bno = 1;
# DAO :String sql = "select * from board where bno = ?";
#(4) 게시물 개별 수정
update board set btitle = '수정제목1' , bcontent = '수정내용1' where bno = 1;
# DAO :String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
#(5) 게시물 개별 삭제 
delete from board where bno = 1;
# DAO :String sql = "delete from board where bno = ?";