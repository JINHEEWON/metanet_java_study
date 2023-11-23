<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<header class="w3-container w3-teal">
  <h1>사원정보 수정</h1>
</header>

<div class="w3-container w3-half w3-margin-top">

<form class="w3-container w3-card-4" action="${pageContext.request.contextPath}/modifyok.do" method="post">

<p>
<input class="w3-input" type="text" name="empno" style="width:90%" value="${requestScope.emp.empno}" readonly>
<label>사원번호</label></p>
<p>
<input class="w3-input" type="text" name="ename" style="width:90%" value="${requestScope.emp.ename}" required>
<label>이름</label></p>
<p>
<input class="w3-input" type="text" name="job" style="width:90%" value="${requestScope.emp.job}" required>
<label>직업</label></p>
<p>
<input class="w3-input" type="text" name="mgr" style="width:90%" value="${requestScope.emp.mgr}" required>
<label>관리자번호</label></p>
<p>
<input class="w3-input" type="text" name="hiredate" style="width:90%" value="${requestScope.emp.hiredate}" readonly>
<label>입사일</label></p>
<p>
<input class="w3-input" type="text" name="sal" style="width:90%" value="${requestScope.emp.sal}" required>
<label>급여</label></p>
<p>
<input class="w3-input" type="text" name="comm" style="width:90%" value="${requestScope.emp.comm}" required>
<label>커미션</label></p>
<p>
<input class="w3-input" type="text" name="deptno" style="width:90%" value="${requestScope.emp.deptno}" readonly>
<label>부서번호</label></p>

<p>
<button class="w3-button w3-section w3-teal w3-ripple"> 수정 </button></p>
<a href="register.do">회원가입</a>

</form>


</div>

</body>
</html> 
