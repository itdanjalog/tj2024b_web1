package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE) // private 디폴트 생성자 가 자동 생성 
public class BoardDao extends Dao {

	@Getter // 싱글톤을 반환하는 메소드를 자동 생성 , getInstance() 자동 생성  
	private static BoardDao instance = new BoardDao();

	// [1] 글쓰기 write SQL 메소드 
	public boolean write( BoardDto boardDto ) {
		try {
			String sql = "insert into board( btitle , bcontent , mno , cno )values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setInt( 3 , boardDto.getMno() );
			ps.setInt( 4 , boardDto.getCno() );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( Exception e ) {
			System.out.println(e );
		}
		return false;
	}
	
	// [2-2] 게시물의 (레코드)전체 개수 조회 SQL 메소드 
	public int getTotalSize( int cno ) {
		try {
			String sql = "select count(*) from board where cno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , cno );
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) { return rs.getInt( 1 ); }
		}catch (Exception e) { System.out.println( e );}
		return 0;
	}
	
	
	
	// [2] 게시물 전체 조회 findAll SQL 메소드 
	public ArrayList< BoardDto > findAll( int cno , int startRow , int display ){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = " select * from board b inner join member m on b.mno = m.mno where b.cno = ? order by b.bno desc limit ? , ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , cno );
			ps.setInt( 2 , startRow );
			ps.setInt( 3 , display);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt("bno") );
				boardDto.setBtitle( rs.getString("btitle") );
				boardDto.setBcontent( rs.getString( "bcontent") );
				boardDto.setBdate( rs.getString("bdate"));
				boardDto.setBview( rs.getInt( "bview"));
				boardDto.setMno( rs.getInt("mno"));
				boardDto.setCno( rs.getInt("cno"));
				boardDto.setMid( rs.getString("mid") ); // 회원테이블과 조인 한 결과 회원아이디 도 조회 가능하다.
				list.add(boardDto);
			}
		}catch (Exception e) {System.out.println(e);}
		return list; 
	} // f end 
	
	// [3] 게시물 개별 삭제 delete SQL 메소드 
	public boolean delete( int bno ) {
		try {
			String sql ="delete from board where bno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno);
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( Exception e ) { System.out.println( e );}
		return false;
	} // f end 
	
	// [4] 게시물 개별 수정 update SQL 메소드 
	public boolean update( BoardDto boardDto ) {
		try {
			String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setInt( 3 , boardDto.getBno() );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch(Exception e ) { System.out.println( e );}
		return false;
	}
	
	// [5] 게시물 개별 조회 findByBno SQL 메소드 
	public BoardDto findByBno( int bno ) {
		try {
			// (1) 특정 게시물 테이블의 게시물 1개 조회 
			// String sql = "select * from board where bno = ? ";
			// (2) 게시물 테이블과 회원 테이블 교집합 구해서 회원아이디로 조회 가능
			// String sql = "select * from board b inner join member m on b.mno = m.mno";
			// (3) 게시물 테이블과 회원 테이블 과 카테고리 테이블 교집합 구해서 회원아이디 와 카테고리명 조회 가능 
			String sql = "select * from board b "
					+ " inner join member m on b.mno = m.mno "
					+ " inner join category c on b.cno = c.cno "
					+ " where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno);
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt("bno") );
				boardDto.setBtitle( rs.getString("btitle") );
				boardDto.setBcontent( rs.getString( "bcontent") );
				boardDto.setBdate( rs.getString("bdate"));
				boardDto.setBview( rs.getInt( "bview"));
				boardDto.setMno( rs.getInt("mno"));
				boardDto.setCno( rs.getInt("cno"));
				boardDto.setMid( rs.getString("mid") ); // 회원테이블과 조인 한 결과 회원아이디 도 조회 가능하다.
				boardDto.setCname( rs.getString( "cname") ); // 카테고리테이블 과 조인 한 결과 카테고리명 도 조회 가능하다.
				return boardDto;
			}
		}catch (Exception e) { System.out.println(e);}
		return null;
	}
	
	// [6] 댓글 쓰기 SQL 처리 함수 
	public boolean replyWrite( Map<String,String> map ) {
		try {
			String sql = "insert into reply ( rcontent , bno , mno ) value( ?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , map.get("rcontent") );
			ps.setString( 2 , map.get("bno") );
			ps.setString( 3 , map.get("mno") );
			int count = ps.executeUpdate();
			if( count == 1 ) return true;
		}catch( Exception e ) { System.out.println(e); }
		return false;
	} // f end 
	// [7] 특정한 게시물의 댓글 조회 SQL 함수 
	public List<Map<String,String>> replyFindAll( int bno ){
		List<Map<String,String>> list = new ArrayList<>();
		try {
			// - reply 댓글 테이블 과 member 회원 테이블을 조인 , 이유 : 댓글 의 mno 를 이용하여 회원의 mid 와 mimg 조회/참조 하기 위해서 
			String sql = "select * from reply r inner join member m on r.mno = m.mno where r.bno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
				Map<String, String> map = new HashMap<>();
				map.put( "rno" ,  rs.getString( "rno" ) );
				map.put( "rcontent" ,  rs.getString( "rcontent" ) );
				map.put( "rdate" ,  rs.getString( "rdate" ) );
				map.put( "mid" ,  rs.getString( "mid" ) );
				map.put( "mno" ,  rs.getString( "mno" ) );
				map.put( "mimg" ,  rs.getString( "mimg" ) );
				list.add( map );
			}
		}catch (Exception e) { System.out.println( e );}
		return list;
	} // f end 
} // class end 

































