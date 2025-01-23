package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.model.dto.MemberDto;

public class MemberDao extends Dao {

	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() { return instance; }
	
	// 1. 회원가입 
	public boolean signup( MemberDto memberDto ) {
		//String sql = "insert into member(mid,mpwd,memail,mimg)values(?,?,?,?)";
		String sql = "insert into member(mid,mpwd,memail)values(?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql  );
			ps.setString( 1 , memberDto.getMid() );
			ps.setString( 2 , memberDto.getMpwd() );
			ps.setString( 3 , memberDto.getMemail() );
			//ps.setString( 4 , memberDto.getMimg() );
			int count = ps.executeUpdate(); 
			if( count == 1 ) { 	
				return true;
			}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	
	// 2. 아이디,비밀번호 검증   [ 로그인 ]
	public MemberDto login( MemberDto memberDto ) {
		String sql = "select * from member where mid = ? and mpwd = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString( 1 , memberDto.getMid() );
			ps.setString( 2 , memberDto.getMpwd() );
			ResultSet rs = ps.executeQuery();
			if( rs.next() ) { 
				// 결과 필드 : mno[1] , mid[2] , mimg[3] , memail[4] , mpoint[5]
				MemberDto dto = new MemberDto( 	rs.getInt("mno"), rs.getString("mid"), null, 
						rs.getString("mimg"), rs.getString("memail") , rs.getString("mdate") );
				return dto;	// 레코드1개 --> 회원1명 --> 회원dto 반환 
			} // 만약에 조건에 충족한 레코드가 존재하면 
		}catch (Exception e) {System.out.println(e);} return null;
	}
	// 3. 로그인된 회원 탈퇴
	public boolean delete( MemberDto memberDto ) {
		String sql = "delete from member where mid = ? and mpwd = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString( 1 , memberDto.getMid() );	ps.setString( 2 , memberDto.getMpwd() );
			int count = ps.executeUpdate();	// 삭제된 레코드 수 반환	// executeUpdate() 조작된 sql 레코드 수 반환
			if( count == 1 ) { return true; }	// 레코드 1개 삭제 성공시 true 
			
		}catch (Exception e) {System.out.println(e);} return false;
	} // 
	
	// 4. 로그인된 회원 수정 
	public boolean update( MemberDto memberDto ) {
		String sql = "update member set mpwd = ? , memail = ? , mimg = ? where mid = ? and mpwd = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString( 1 , memberDto.getMpwd() ); 	ps.setString( 2 , memberDto.getMemail() );
			ps.setString( 3 , memberDto.getMimg() ); 	ps.setString( 4 , memberDto.getMid() ); ps.setString( 5 , memberDto.getMpwd() );
			int count = ps.executeUpdate();	// 수정된 레코드 수 반환 
			if( count == 1 ) { return true; }	// 레코드 1개 수정 성공시 true 
			
		}catch (Exception e) {System.out.println(e);} return false;
	}
	
	
}





















