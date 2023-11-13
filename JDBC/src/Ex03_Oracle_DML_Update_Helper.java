import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.kosa.utils.ConnectionHelper;

public class Ex03_Oracle_DML_Update_Helper {

	public static void main(String[] args) throws SQLException{
//		Connection conn = null;
//		conn = ConnectionHelper.getConnection("oracle");
//		System.out.println(conn.toString());
//		System.out.println(conn.getMetaData().getDatabaseProductName());
//		System.out.println(conn.getMetaData().getDatabaseProductVersion());
//		System.out.println(conn.isClosed());	//false
//		ConnectionHelper.close(conn);
//		System.out.println(conn.isClosed());	//true
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "update dmlemp set ename=?, sal=?, job=?, deptno=? where empno=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "홍길동");
			pstmt.setInt(2, 1000);
			pstmt.setString(3, "IT");
			pstmt.setInt(4, 10);
			pstmt.setInt(5, 100);
			
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("row : " + row);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
	}

}
