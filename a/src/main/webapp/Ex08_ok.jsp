<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java 코드 구현 (back단)
	//실 개발에서는 jsp 페이지는 view 역할
	
	String userid = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>당신이 입력한 테이터</h3>
	ID : <%= userid %>
	PW : <%= pwd %>
</body>
</html>