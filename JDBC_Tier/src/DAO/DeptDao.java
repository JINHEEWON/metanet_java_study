package DAO;
//CRUD 함수...
//추가사항 (LIKE 사용해서 부서이름 검색 함수)

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Dept;
import UTILS.ConnectionHelper;

//1. 전체조회
//2. 조건조회
//3. 삽입
//4. 수정
//5. 삭제
//6. 문자열 LIKE 검색 (부서이름) 
public class DeptDao {

	public List<Dept> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> deptlist = new ArrayList<Dept>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select * from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				deptlist.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return deptlist;
	}
	
	public Dept selectByDeptno(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dept dept = new Dept();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select * from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return dept;
	}
	
	public int insert(Dept dept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int ret = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "insert into dept(deptno, dname, loc) values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLoc());
			
			ret = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return ret;
	}
	
	public int update(Dept dept) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int ret = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "update dept set dname = ?, loc = ? where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			ret = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return ret;
	}
	public int delete(int deptno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int ret = 0;
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "delete from dept where deptno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			ret = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return ret;
	}
	public List<Dept> selectByDname(String dname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select * from dept where dname like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dname + "%");
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Dept dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
		}
		return list;
	} 
}
