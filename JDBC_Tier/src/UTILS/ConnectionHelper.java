package UTILS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionHelper {
	//함수....static....Connection 인터페이스 리턴 타입 ...
	public static Connection getConnection(String dsn) {
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
			}else if(dsn.equals("mariadb")) {
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static Connection getConnection(String dsn, String id, String pw) {
		Connection conn = null;
		try {
			if(dsn.equals("oracle")) {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", id, pw);
			}else if(dsn.equals("mariadb")) {
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void close(Statement stmt) {
		if(stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
