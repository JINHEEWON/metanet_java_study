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
		
		/*
		 PreparedStatement (준비된 Statement )

		(1) 설명 
		미리 SQL문이 셋팅된 Statement 가 DB가 전송되어져서 컴파일되어지고, SQL문의 ?만 나중에 추가 셋팅해서 실행 
		이 되어지는 준비된 Statement 
		
		(2) 장점
		<1> Statement 에 비해서 반복적인 SQL문을 사용할 경우에 더 빠르다. ( 특히, 검색문 )
		<2> DB컬럼타입과 상관없이 ?하나로 표시하면 되므로 개발자가 헷깔리지 않고 쉽다. ( 특히, INSERT문 )
		(이유: ?를 제외한 SQL문이 DB에서 미리 컴파일되어져서 대기)
		
		(3) 단점
		SQL문마다 PreparedStatement 객체를 각각 생성해야 하므로 재사용불가
		(but, Statement 객체는 SQL문이 달라지더라도 한 개만 생성해서 재사용이 가능하다. ) 
		 */
		
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
