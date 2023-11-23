<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<header class="w3-container w3-teal">
  <h1>로그인</h1>
</header>

<div class="w3-container w3-half w3-margin-top">

<form class="w3-container w3-card-4" action="${pageContext.request.contextPath}/loginok.do" method="post">

<p>
<input class="w3-input" type="text" name="empno" style="width:90%" required>
<label>사원번호</label></p>
<p>
<input class="w3-input" type="text" name="ename" style="width:90%" required>
<label>이름</label></p>

<p>
<button class="w3-button w3-section w3-teal w3-ripple"> Log in </button></p>
<a href="register.do">회원가입</a>

</form>


</div>

</body>
</html> 
