<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
	String id = request.getParameter("ID");
	if(id.equals("hong")){
%>
	<%=id%><img src="images/1.jpg" style="width:100px;height:100px">
<%		
	}
%>

<% 
/*

	EL & JSTL 구문 WAS해석(서버쪽 스크립트)
		<c:set 변수생성, 값을 저장
		>

*/
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL&JSTL</h3>
	<c:if test="${param.ID == 'hong'}">
		${param.ID}<img src="images/1.jpg" style="width:100px;height:100px">
	</c:if>
	<br>
	
	<!-- 
	http://localhost:8090/WebJSP_EL_JSTL/Ex03_EL_JSTL.jsp?ID=hong&age=50
	age parameter 값이 20보다 크면 나이 출력	
	-->
	<c:if test="${param.age > 20}" var="result">
		param.age = ${param.age}
	</c:if>
	<br>
	result : ${result}

</body>
</html>