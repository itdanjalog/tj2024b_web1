package web.model.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.MemberDto;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE )
public class MemberDao extends Dao {

	@Getter
	private static final MemberDao instance = new MemberDao(); // 싱글톤 
	
	// private MemberDao() { }
	//public static MemberDao getInstance() { return instance;} 

	
	// 1. 회원가입 SQL 처리 메소드 
	public boolean signup( MemberDto memberDto ) {
		try {
			// [1] SQL 작성한다.
			String sql ="insert into member( mid , mpwd , mname , mphone ) "
					+ "values( '"+memberDto.getMid()+"' , '"+memberDto.getMpwd()+"', '"+memberDto.getMname()+"', '"+memberDto.getMphone()+"' )";
			// [2] DB와 연동된 곳에 SQL 기재한다. 		- 연동된 db에 sql 기재하는 방법 : conn.prepareStatement( SQL )
			PreparedStatement ps = conn.prepareStatement(sql);
			// [3] 기재된 SQL를 실행하고 결과를 받는다. . 	- 기재된 sql를 실행하는 방법 : ps.executeUpdate()
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( count == 1 ) { return true; }
		}catch( SQLException e ) { System.out.println( e ); }
		return false;
	} // f end 
	
	// 2. 로그인 SQL 처리 메소드
	public int login( MemberDto memberDto ) {
		// int : SQL로 조회된 회원번호를 반환하기 위해서
		try {
			// [1] SQL 작성한다.
			String sql = "select mno from member where mid = ? and mpwd = ? ";
			// [2] DB와 연동된 곳에 SQL 기재한다.
			PreparedStatement ps =  conn.prepareStatement(sql);
			// [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setString( 1 , memberDto.getMid() );
			ps.setString( 2 , memberDto.getMpwd() );
			// [3] 기재된 SQL 실행하고 결과를 받는다.
			ResultSet rs = ps.executeQuery();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( rs.next() ) {
				int mno = rs.getInt("mno");
				return mno;
			}
		}catch( SQLException e ) { System.out.println( e ); }
		return 0;
	} // f end 
	// 6. 내정보기 보기 SQL 처리 메소드 
	public MemberDto myInfo( int loginMno ) {
		try {
			String sql ="select * from member where mno = ? "; // [1] SQL 작성한다.
			PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
			ps.setInt(  1 , loginMno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
			ResultSet rs = ps.executeQuery(); // [3] 기재된 SQL 실행하고 결과를 받는다.
			if( rs.next() ) { // [4] 결과에 따른 처리 및 반환를 한다.
				MemberDto memberDto = new MemberDto();
				memberDto.setMid( rs.getString("mid") );
				memberDto.setMno( rs.getInt("mno") );
				memberDto.setMname( rs.getString("mname" ) );
				memberDto.setMphone( rs.getString("mphone") );
				memberDto.setMdate( rs.getString("mdate") );
				return memberDto; // 조회된 회원정보를 반환한다.
			}
		}catch(SQLException e ) { System.out.println(e);}
		return null; // 조회된 회원정보가 없을때. null 반환한다
	} // f end 
	// 7. 회원탈퇴 SQL 처리 메소드 
	public boolean delete( int loginMno ) {
		try {
			String sql = "delete from member where mno = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , loginMno );
			int count = ps.executeUpdate();
			if( count == 1 )return true;
		}catch( SQLException e ) { System.out.println(e); }
		return false;
	} // f end 
	

	public boolean update( MemberDto memberDto ) {
		try {
			// [1] SQL 작성한다.
			String sql = "update member set mpwd = ? , mname = ? , mphone = ? where mno = ? ";
			// [2] DB와 연동된 곳(conn)에 SQL 기재한다.
			PreparedStatement ps = conn.prepareStatement( sql );
			// [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setString( 1 , memberDto.getMpwd() );
			ps.setString( 2 , memberDto.getMname() );
			ps.setString( 3 , memberDto.getMphone() );
			ps.setInt( 4 , memberDto.getMno() );
			// [3] 기재된 SQL 실행하고 결과를 받는다.
			int count = ps.executeUpdate();
			// [4] 결과에 따른 처리 및 반환를 한다.
			if( count == 1 ) { return true; } // 수정 성공 했을때.
		}catch (SQLException e) {		System.out.println( e ); }
		return false; // 수정 실패 했을때.
	} // f end
	
	
	
	
}
