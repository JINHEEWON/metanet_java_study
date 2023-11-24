<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script>

	window.onload = function() {
		let checkbtn = document.getElementById('checkbtn');
		checkbtn.onclick = function() {
			let value = document.getElementById('empno').value;
			let str = "${pageContext.request.contextPath}/logincheck.ajax?empno=" + value;
			//checkbtn.setAttribute("href", str);
			
			fetch(str)
		    .then((response) => response.json())	
		    .then((data) => {
		    	console.log(data);
		    	let text = document.getElementById('no');
			    if(!data.isExist) {
			    	text.style.display = 'inline';
			    } else {
			    	text.style.display = 'none';
			    }
		    })
		 }
	}
</script>
<body>
	<header class="w3-container w3-teal">
	  <h1>회원가입</h1>
	</header>
	
	<div class="w3-container w3-half w3-margin-top">
	
	<form class="w3-container w3-card-4" form action="${pageContext.request.contextPath}/registerok.do" method="post">
	
	<p>
	<input class="w3-input" type="text" id="empno" name="empno" style="width:90%" required>
	<button type="button" id="checkbtn" class="w3-button w3-section w3-teal w3-ripple"> 확인 </button></p>
	<label>사원번호</label><span id="no" style="margin-left:20px; color:red; display:none">(사용할 수 없는 번호)</span></p>
	<p>
	<input class="w3-input" type="text" name="ename" style="width:90%" required>
	<label>이름</label></p>
	
	<p>
	<button class="w3-button w3-section w3-teal w3-ripple"> 회원가입 </button></p>
	
	</form>
	
	
	</div>
</body>
</html>