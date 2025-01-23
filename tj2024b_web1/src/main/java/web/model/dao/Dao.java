package web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	public Connection con;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jspweb",
					"root",
					"1234");
			System.out.println("[연동성공]");
		}catch (Exception e) {System.out.println(e);}
	}
	
}