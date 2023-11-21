<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.bit.utils.Singleton_Helper"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("userid") == null || !session.getAttribute("userid").equals("admin") ){
		//강제로 페이지 이동
		out.print("<script>location.href='Ex02_JDBC_Login.jsp'</script>");
	}
    
	request.setCharacterEncoding("UTF-8");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}
 
tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}
 
td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table style="width: 900px; height: 500px ;margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
			 <!--  데이터 받아서 UI 구성 -->
			 <%
			 	String name=request.getParameter("search");	
			 	request.setAttribute("name", name);
			 
			 	Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
			    
				//where ename like '%길동%'
				conn = Singleton_Helper.getConnection("oracle");
				String sql="select count(*) from koreamember where name like ?";
				String sql2 ="select id, name, email from koreamember where name like '%"+name+"%'";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, '%'+name+'%');
				rs= pstmt.executeQuery();
				int rowcount=0;
				if(rs.next()){
					rowcount = rs.getInt(1); //조회건수
					request.setAttribute("rowcount", rowcount);
				}
			 %>
				<table style="width: 400px;height: 100px;margin-left: auto;margin-right: auto">
							<tr><th colspan="4">회원리스트</th></tr>
							<%
								if(rowcount > 0){
									pstmt = conn.prepareStatement(sql2); 
									rs = pstmt.executeQuery();
									List<String> idlist = new ArrayList();
									List<String> mnamelist = new ArrayList();
									List<String> emaillist = new ArrayList();
									while(rs.next()){
										idlist.add(rs.getString(1));
										mnamelist.add(rs.getString(2));
										emaillist.add(rs.getString(3));
									}
									request.setAttribute("idlist", idlist);
									request.setAttribute("mnamelist", mnamelist);
									request.setAttribute("emaillist", emaillist);
								}
							%>
							<c:if test="${rowcount >0}">
								<c:forEach var="i" begin="0" end="${rowcount-1}">
   	   							<tr>
				   	   				<td>${idlist.get(i)}</td>
					      			<td>${mnamelist.get(i)}</td>
					      			<td>${emaillist.get(i)}</td>
					      		</tr>
	   	   						</c:forEach>
	   	   						<tr><td colspan='3'>
	   	   							<b>[${name}] 조회결과 ${rowcount} 건 조회</b>
	   	   						</td></tr>
	   	   						
							</c:if>
							<c:if test="${rowcount<=0}">
								<tr><td colspan='3'>
		   	   						<b>[${name}] 조회결과가 없습니다</b>
		   	   					</td></tr>
	   	   					</c:if>
							
				</table>
				<a href="Ex03_Memberlist.jsp">회원 목록 페이지</a>
			<%
				Singleton_Helper.close(rs);
				Singleton_Helper.close(pstmt);
			%>		
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>