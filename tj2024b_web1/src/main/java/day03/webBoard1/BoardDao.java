package day03.webBoard1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


//drop database if exists mydb0120;
//create database mydb0120;
//use mydb0120;
//create table board(
//	bno int auto_increment ,
//    btitle varchar(100) , 
//    bcontent longtext , 
//    bwriter varchar(30) ,
//    bpwd varchar(30) ,
//    constraint primary key( bno )
//);

public class BoardDao {
	
	private Connection conn;
	// + 싱글톤 
	private static BoardDao instance = new BoardDao();
	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0120",
					"root" , "1234");
		}catch( Exception e ) { System.out.println(e); }
		
	}
	public static BoardDao getInstance() { return instance; }
	
	// 1. 등록 
	public boolean write( BoardDto boardDto ) {
		try {
			String sql = "insert into board( btitle,bcontent,bwriter,bpwd) "
					+ " values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setString( 3 , boardDto.getBwriter() );
			ps.setString( 4 , boardDto.getBpwd());
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch (Exception e) { System.out.println( e );}
		return false;
	}
	// 2. 전체 출력 
	public ArrayList< BoardDto > findAll(){
	
		ArrayList< BoardDto > list = new ArrayList<BoardDto>();
		try {
			String sql = "select * from board;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while( rs.next() ) {
			
				BoardDto boardDto = new BoardDto();
				boardDto.setBno( rs.getInt( "bno" ));
				boardDto.setBtitle( rs.getString( "btitle"));
				boardDto.setBcontent( rs.getString("bcontent"));
				boardDto.setBwriter( rs.getString("bwriter") );
				list.add(boardDto);
			}
			
		}catch (Exception e) { System.out.println( e );}
		return list;
	}
	// 3. 수정 
	public boolean update( BoardDto boardDto ) {
		try {
			String sql = "update board set btitle = ? , bcontent = ? where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString( 1 , boardDto.getBtitle() );
			ps.setString( 2 , boardDto.getBcontent() );
			ps.setInt( 3 , boardDto.getBno() );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch (Exception e) { System.out.println( e );}
		return false;
	}
	// 4. 삭제 
	public boolean delete( int bno ) {
		try {
			String sql = "delete from board where bno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt( 1 , bno );
			int count = ps.executeUpdate();
			if( count == 1 ) { return true; }
		}catch (Exception e) { System.out.println( e );}
		return false;
	}
}








