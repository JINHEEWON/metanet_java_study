package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.EmpDto;
import kr.or.kosa.utils.ConnectionHelper;

/*
 1. DB DBCP 사용
 2. insert
 2.1 insert into mvcregister(id,pwd,email) values(?,?,?)

*/

//1. 전체조회 
//2. 조건조회(이름검색)
//3. 삽입 
//4. 수정 
//5. 삭제 

public class EmpDao {
	
	//전체 사원 리스트
	public List<EmpDto> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<EmpDto> emplist = new ArrayList<EmpDto>();
		try {
			  conn = ConnectionHelper.getConnection("oracle");
			  String sql="select * from emp";
			  pstmt = conn.prepareStatement(sql);
			  rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
					EmpDto e = new EmpDto();
					e.setEmpno(rs.getInt("empno"));
					e.setEname(rs.getString("ename"));
					e.setJob(rs.getString("job"));
					e.setMgr(rs.getInt("mgr"));
					e.setHiredate(rs.getString("hiredate"));
					e.setSal(rs.getInt("sal"));
					e.setComm(rs.getInt("comm"));
					e.setDeptno(rs.getInt("deptno"));
					
					emplist.add(e);
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn); //반환
		}
		return emplist;
	}
	
	//특정사원 검색(로그인)
	public EmpDto selectEmpByEmpnoEname(int empno, String ename) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		EmpDto empdto = new EmpDto();
		try {
			  conn = ConnectionHelper.getConnection("oracle");
			  String sql="select * from emp where empno=? and ename=?";
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setInt(1, empno);
			  pstmt.setString(2, ename);
			  
			  rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
				  empdto.setEmpno(rs.getInt("empno"));
				  empdto.setEname(rs.getString("ename"));
				  empdto.setJob(rs.getString("job"));
				  empdto.setMgr(rs.getInt("mgr"));
				  empdto.setHiredate(rs.getString("hiredate"));
				  empdto.setSal(rs.getInt("sal"));
				  empdto.setComm(rs.getInt("comm"));
				  empdto.setDeptno(rs.getInt("deptno"));
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn); //반환
		}
		return empdto;
	}
	
	//사원 검색(이름)
	public List<EmpDto> selectEmpByName(String ename) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<EmpDto> emplist = new ArrayList<EmpDto>();
		try {
			  conn = ConnectionHelper.getConnection("oracle");
			  String sql="select * from emp where ename like ?";
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setString(1, "%"+ename+"%");
			  
			  rs = pstmt.executeQuery();
			  
			  while(rs.next()) {
					EmpDto e = new EmpDto();
					e.setEmpno(rs.getInt("empno"));
					e.setEname(rs.getString("ename"));
					e.setJob(rs.getString("job"));
					e.setMgr(rs.getInt("mgr"));
					e.setHiredate(rs.getString("hiredate"));
					e.setSal(rs.getInt("sal"));
					e.setComm(rs.getInt("comm"));
					e.setDeptno(rs.getInt("deptno"));
					
					emplist.add(e);
				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(rs);
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn); //반환
		}
		return emplist;
	}
	
	//사원정보 삽입(회원가입)
	public int insert(EmpDto empdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		try {
			  conn = ConnectionHelper.getConnection("oracle");
			  String sql="insert into emp(empno, ename) values(?,?)";
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setInt(1,empdto.getEmpno());
			  pstmt.setString(2, empdto.getEname());
			  
			  result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn); //반환
		}
		return result;
	}
	
	//사원정보 수정
	public int update(EmpDto empdto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		try {
			  conn = ConnectionHelper.getConnection("oracle");
			  //update emp set job = 'TTT' where deptno=30;
			  String sql="update emp set ename=?, job=?, mgr=?, sal=?, comm=? where empno=?";
			  pstmt = conn.prepareStatement(sql);
			  
			  System.out.println(empdto.toString());
			  
			  pstmt.setString(1,empdto.getEname());
			  pstmt.setString(2, empdto.getJob());
			  pstmt.setInt(3,empdto.getMgr());
			  pstmt.setInt(4,empdto.getSal());
			  pstmt.setInt(5, empdto.getComm());
			  pstmt.setInt(6, empdto.getEmpno());
			  
			  result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn); //반환
		}
		return result;
	}
	
	//사원 삭제
	public int deletByDeptno(int empno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result =0;
		try {
			  conn = ConnectionHelper.getConnection("oracle");
			  String sql="delete from emp where empno=?";
			  pstmt = conn.prepareStatement(sql);
			  
			  pstmt.setInt(1,empno);
			  
			  result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn); //반환
		}
		return result;
	}

}
