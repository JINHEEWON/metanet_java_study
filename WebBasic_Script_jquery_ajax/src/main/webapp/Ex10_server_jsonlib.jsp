<%@page import="net.sf.json.JSONArray"%>
<%@page import="kr.or.kosa.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//CORS
	//교차 출처 리소스 공유 (Cross-origin resource sharing)
	//비동기 작업 : 다른 출처 허용 안되요
	//('Access-Control-Allow-origin', '*');
	//https://inpa.tistory.com/entry/WEB-%F0%9F%93%9A-CORS-%F0%9F%92%AF-%EC%A0%95%EB%A6%AC-%ED%95%B4%EA%B2%B0-%EB%B0%A9%EB%B2%95-%F0%9F%91%8F
	//참고 사이트
	    response.addHeader("Access-Control-Allow-Origin", "*");
	
		
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = null; //Connection 인터페이스 ...
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kosa","1004");
		
		Statement stmt = conn.createStatement(); //명령 객체 얻어오기
		String sql = "select empno , ename , sal , job ,comm from emp";
		//select to_char(date) from  >> DTO 에서 String  으로 
		ResultSet rs = stmt.executeQuery(sql); //DB서버에서 실행되고 결과를 생성
		
		//POINT
		//DTO 객체 데이터 담아야 -> JSON변환 가능
		List<Emp> list = new ArrayList<Emp>();
		
		while(rs.next()){
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setSal(rs.getInt("sal"));
			emp.setJob(rs.getString("job"));
			emp.setComm(rs.getInt("comm"));
			
			list.add(emp);
		}
		
		//[{},{},{},{} .....]
		//String json = "[" + "(" + "empno:" + rs.get ....
				
		JSONArray jsonlist = JSONArray.fromObject(list);
		
		stmt.close();
		rs.close();
		conn.close();
%>
<%=jsonlist%>