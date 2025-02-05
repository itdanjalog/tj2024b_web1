package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;

@NoArgsConstructor( access = lombok.AccessLevel.PRIVATE ) // 클래스내 디폴트생성자를 private 적용 
public class BoardDao extends Dao {
	
	@Getter
	private static BoardDao instance = new BoardDao();
	
	// [1]. 회원가입 SQL 처리 메소드 
	public int write(BoardDto boardDto) {
	    try {
	        // [1] SQL 작성
	        String sql = "INSERT INTO board (btitle, bcontent, mno, cno) VALUES (?, ?, ?, ?)";
	        
	        // [2] DB와 연동된 곳에 SQL 기재
	        PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	        ps.setString(1, boardDto.getBtitle());  // 제목
	        ps.setString(2, boardDto.getBcontent()); // 내용
	        ps.setInt(3, boardDto.getMno());  // 작성자 (회원번호)
	        ps.setInt(4, boardDto.getCno());  // 카테고리 번호

	        // [3] SQL 실행
	        int count = ps.executeUpdate();

	        // [4] 결과에 따른 처리 및 반환
	        if (count == 1) { 
	            ResultSet rs = ps.getGeneratedKeys();
	            if (rs.next()) {
	                int bno = rs.getInt(1);
	                return bno; // 게시물 등록 성공 시 게시물 번호 반환
	            }
	        }
	    } catch (SQLException e) { System.out.println(e);}
	    return 0; // 실패 시 0 반환
	}
	
	// [2] 카테고리 별 게시물 조회 + 페이징
	public List<BoardDto> findByCno( int cno , int startRow , int display ){
		
		List< BoardDto > list = new ArrayList<BoardDto>();
		try {
			// String sql ="select * from board b inner join member m on b.mno = m.mno where cno = ? "; // [1] SQL 작성한다.
			String sql ="select * from board b inner join member m on b.mno = m.mno "
					+ " where cno = ? order by b.bno desc limit ? , ? "; // [1] SQL 작성한다.
		
			PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
			ps.setInt(  1 , cno); // [*] 기재된 SQL 에 매개변수 값 대입한다.
			ps.setInt(  2 , startRow );
			ps.setInt(  3 , display );
			ResultSet rs = ps.executeQuery(); // [3] 기재된 SQL 실행하고 결과를 받는다.
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt("bno") );
				boardDto.setBtitle( rs.getString("btitle"));
				boardDto.setBview( rs.getInt("bview") );
				boardDto.setBdate( rs.getString("bdate") );
				boardDto.setCno( rs.getInt("cno") );
				boardDto.setMno( rs.getInt("mno") );
				boardDto.setMid(  rs.getString("mid")  );
				list.add(boardDto);
			}
		}catch(SQLException e ) { System.out.println(e);}
		return list; // 조회된 회원정보가 없을때. null 반환한다
	}
	
	// [3] 카테고리 별 게시물 조회 + 페이징
	public BoardDto findById( int bno ){
		
		try {
			// String sql ="select * from board b inner join member m on b.mno = m.mno where cno = ? "; // [1] SQL 작성한다.
			String sql ="select * from board b inner join member m on b.mno = m.mno inner join category c on b.cno = c.cno "
					+ " where bno = ? "; // [1] SQL 작성한다.
		
			PreparedStatement ps = conn.prepareStatement(sql); // [2] DB와 연동된 곳에 SQL 기재한다.
			ps.setInt(  1 , bno); 
			ResultSet rs = ps.executeQuery(); // [3] 기재된 SQL 실행하고 결과를 받는다.
			while( rs.next() ) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt("bno") );
				boardDto.setBtitle( rs.getString("btitle"));
				boardDto.setBcontent( rs.getString( "bcontent") );
				boardDto.setBview( rs.getInt("bview") );
				boardDto.setBdate( rs.getString("bdate") );
				boardDto.setCno( rs.getInt("cno") );
				boardDto.setMno( rs.getInt("mno") );
				boardDto.setMid(  rs.getString("mid")  );
				boardDto.setCname( rs.getString("cname")  );
				return boardDto;
			}
		}catch(SQLException e ) { System.out.println(e);}
		return null; // 조회된 회원정보가 없을때. null 반환한다
	}
	
	
} // class end 
